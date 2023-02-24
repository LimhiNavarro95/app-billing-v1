package com.nav.billing.appbillingv1.service.domain.customer;

import com.nav.billing.appbillingv1.entities.domain.Customer;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import com.nav.billing.appbillingv1.service.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService extends GenericService<Customer> {

  Optional<Customer> findCustomerByRfc(String rfc) throws ServiceException;

  List<Customer> findByLikeRFC(Customer customer) throws ServiceException;

  Page<Customer> findAllCustomersPaging(Pageable pageable) throws ServiceException;

}
