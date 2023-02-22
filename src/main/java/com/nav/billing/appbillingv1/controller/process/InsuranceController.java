package com.nav.billing.appbillingv1.controller.process;

import com.nav.billing.appbillingv1.entities.process.InsuranceCoverage;
import com.nav.billing.appbillingv1.entities.process.InsurancePolicy;
import com.nav.billing.appbillingv1.service.domain.customer.CustomerService;
import com.nav.billing.appbillingv1.service.process.insurance.InsuranceCoverageService;
import com.nav.billing.appbillingv1.service.process.insurance.InsurancePolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.nav.billing.appbillingv1.commons.GlobalConstants.INSURANCE_API;

@Slf4j
@RestController
@RequestMapping(INSURANCE_API) // -> v1/insurance
public class InsuranceController {

  private final InsurancePolicyService insurancePolicyService;
  private final InsuranceCoverageService insuranceCoverageService;
  private final CustomerService customerService;

  public InsuranceController(InsurancePolicyService insurancePolicyService, InsuranceCoverageService insuranceCoverageService, CustomerService customerService) {
    this.insurancePolicyService = insurancePolicyService;
    this.insuranceCoverageService = insuranceCoverageService;
    this.customerService = customerService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id){
    try {
      Optional<InsurancePolicy> optionalInsurancePolicy = insurancePolicyService.findById(id);
      if (optionalInsurancePolicy.isEmpty()){
        return  ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(optionalInsurancePolicy.get());

    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }
  }

  /* TODO arreglar este servicio
  @GetMapping("/by-customer/{id}")
  public ResponseEntity<?> findByCustomer(@PathVariable Long id){
    try {
      List<InsurancePolicy> insurancePolicies = insurancePolicyService.findInsurancePoliciesByCustomer(id);
      if (insurancePolicies.isEmpty()){
        return  ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(insurancePolicies);

    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }
  }*/

  @PostMapping
  public ResponseEntity<?> registerInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy){

    try {

      System.out.println("====================\n " + insurancePolicy.toString() + "\n===============\n");

      Optional<InsuranceCoverage> optionalInsuranceCoverage = insuranceCoverageService.findById(insurancePolicy.getInsuranceCoverage().getInsuranceCoverageId());

      //se obtiene los montos de las coverturas para la poliza de seguro
      long totalInsuranceAmount = 0L;
      totalInsuranceAmount += optionalInsuranceCoverage.get().getFirstCoverageAmount();
      totalInsuranceAmount += optionalInsuranceCoverage.get().getSecondCoverageAmount();
      totalInsuranceAmount += optionalInsuranceCoverage.get().getThirdCoverageAmount();

      insurancePolicy.setTotalInsuranceAmount(totalInsuranceAmount);

      //se hace el registro de la poliza de seguro
      insurancePolicyService.save(insurancePolicy);

      return ResponseEntity.ok(insurancePolicy);

    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

}
