package com.nav.billing.appbillingv1.controller;

import com.nav.billing.appbillingv1.entities.domain.Customer;
import com.nav.billing.appbillingv1.service.domain.customer.CustomerService;
import com.nav.billing.appbillingv1.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.nav.billing.appbillingv1.commons.GlobalConstants.CUSTOMER_API;
import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping(CUSTOMER_API) // uri -> /v1/customer
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id){

    try {
      Optional<Customer> optionalCustomer = customerService.findById(id);
      if (optionalCustomer.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(optionalCustomer.get());
    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

  @GetMapping("/rfc")
  public ResponseEntity<?> findCustomerbyRfc(@RequestParam String rfc){

    try{
      Optional<Customer> customer = customerService.findCustomerByRfc(rfc);
      if (customer.isEmpty()){
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(customer.get());
    } catch (Exception e){
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

  /*@GetMapping("/by-businessName")
  public ResponseEntity<?> findByLikeRazonSocial(@RequestParam String businessName){

    try {
      Customer customer = new Customer();
      customer.setBusinessName(businessName);
      List<Customer> customers = customerService.findByLikeObject(customer);
      if (customers.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(customers);
    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }*/

  @GetMapping("/all-customers")
  public ResponseEntity<?> findAllCustomersPaged(@RequestParam Integer page, @RequestParam Integer size){

    try {

      Pageable pageable = PageRequest.of(page -1, size);
      Page<Customer> customers = customerService.findAllCustomersPaging(pageable);

      if (customers.isEmpty()){
        return ResponseEntity.noContent().build();
      } else {
        return ResponseEntity.ok(customers.getContent());
      }

    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

  @PostMapping
  public ResponseEntity<?> registerCustomer(@RequestBody @Validated Customer customer, BindingResult bindingResult){

    //el objeto binding result apoya para comprobar que el objeto tenga los atributos correctos
    if (bindingResult.hasErrors()){
      return WebUtil.getErrors(bindingResult);
    }

    try {
      Customer customerRst = customerService.save(customer);
      if (isNull(customerRst)){
        return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.status(HttpStatus.CREATED).body(customerRst);
    } catch (Exception e){
      return ResponseEntity.internalServerError().build();
    }
  }

  @PutMapping("/{customerId}")
  public ResponseEntity<?> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer){

    try{
      // se asigna el ID al customer ya que el objeto de la peticion no lo tiene
      customer.setCustomerId(customerId);
      Customer customerUpdated = customerService.update(customer);

      if (isNull(customerUpdated)){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
      }
      return ResponseEntity.status(HttpStatus.OK).build();

    } catch (Exception e) {
      log.error(e.getMessage());
      return ResponseEntity.internalServerError().build();
    }

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteCustomer(@PathVariable Long id){

    try {

      Customer customer = new Customer();
      customer.setCustomerId(id);

      if (customerService.delete(customer)){
        return ResponseEntity.status(HttpStatus.OK).build();
      }
      return ResponseEntity.badRequest().build();

    } catch (Exception e) {
      log.error(e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

  }


}
