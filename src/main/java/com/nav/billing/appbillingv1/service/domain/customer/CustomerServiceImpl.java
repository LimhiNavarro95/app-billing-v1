package com.nav.billing.appbillingv1.service.domain.customer;

import com.nav.billing.appbillingv1.entities.domain.Customer;
import com.nav.billing.appbillingv1.repository.domain.CustomerRepository;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import com.nav.billing.appbillingv1.util.BDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

  public CustomerRepository customerRepository;

  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }


  @Override
  public Optional<Customer> findCustomerByRfc(String rfc) throws ServiceException {
    try{
      return customerRepository.findCustomerByRfc(rfc);
    } catch (Exception e){
      throw new ServiceException(e);
    }
  }

  @Override
  public Page<Customer> findAllCustomersPaging(Pageable pageable) throws ServiceException {
    try {
      return customerRepository.findAllCustomers(pageable);
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public List<Customer> findByLikeObject(Customer customer) throws ServiceException {
    try{
      return customerRepository.findByLikeBusinessName(BDUtil.getLike(customer.getBusinessName()));
    } catch (Exception e){
      throw new ServiceException(e);
    }
  }

  @Override
  public Optional<Customer> findById(Long id) throws ServiceException {
    try{
      return customerRepository.findCustomerById(id);
    } catch (Exception e){
      throw new ServiceException(e);
    }
  }

  @Override
  public Customer save(Customer customer) throws ServiceException {
    try {
      return customerRepository.save(customer);
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public Customer update(Customer customer) throws ServiceException {
    try{
      //-Se obtiene por medio del Id del cliente a modifiar la info actual en BD
      Customer currentCustomerData = this.findById(customer.getCustomerId()).orElse(null);
      if (!isNull(currentCustomerData)){
        BeanUtils.copyProperties(customer, currentCustomerData);
        return customerRepository.save(currentCustomerData);
      }
      return null;
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  @Transactional
  @Override
  public Boolean delete(Customer customer) throws ServiceException {
    try {
      customerRepository.delete(customer.getCustomerId());
      return true;
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

}
