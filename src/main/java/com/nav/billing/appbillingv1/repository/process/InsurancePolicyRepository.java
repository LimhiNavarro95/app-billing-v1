package com.nav.billing.appbillingv1.repository.process;

import com.nav.billing.appbillingv1.entities.process.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {

  @Query("select ins_pol from InsurancePolicy ins_pol where ins_pol.insurancePolicyId = :insurancePolicyId and ins_pol.status = '1'")
  Optional<InsurancePolicy> findInsurancePolicyById(@Param("insurancePolicyId") Long insurancePolicyId);

  @Query("select ins_pol from InsurancePolicy ins_pol where ins_pol.customer.customerId = :customerId and ins_pol.status = '1'")
  List<InsurancePolicy> findInsurancePoliciesByCustomer(@Param("customerId") Long customerId);

}
