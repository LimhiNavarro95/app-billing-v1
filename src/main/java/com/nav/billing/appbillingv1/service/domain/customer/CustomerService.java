package com.nav.billing.appbillingv1.service.domain.customer;

import com.nav.billing.appbillingv1.entities.domain.Customer;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import com.nav.billing.appbillingv1.service.generic.GenericService;

import java.util.Optional;

public interface CustomerService extends GenericService<Customer> {

  Optional<Customer> findCustomerByRfc(String rfc) throws ServiceException;

}
