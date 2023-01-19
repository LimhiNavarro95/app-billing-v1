package com.nav.billing.appbillingv1.repository.domain;

import com.nav.billing.appbillingv1.entities.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  //Encuentra por razon social
  @Query("select c from Customer c where upper(c.businessName) like upper(:businessName) and c.status='1'")
  List<Customer> findByLikeBusinessName(@Param("businessName") String businessName);

  @Query("select c from Customer c where c.rfc = :rfc and c.status = '1'")
  Optional<Customer> findCustomerByRfc(@Param("rfc") String rfc);

  @Modifying
  @Query(nativeQuery = true, value = "UPDATE CUSTOMER SET status = '0' WHERE id_customer = :id") // SQL Nativo
  void delete(@Param("id") Long id);

}
