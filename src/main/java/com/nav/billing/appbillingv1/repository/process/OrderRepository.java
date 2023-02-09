package com.nav.billing.appbillingv1.repository.process;

import com.nav.billing.appbillingv1.entities.process.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  //methods

}
