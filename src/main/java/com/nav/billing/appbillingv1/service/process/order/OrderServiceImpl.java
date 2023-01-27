package com.nav.billing.appbillingv1.service.process.order;

import com.nav.billing.appbillingv1.entities.process.Order;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

  public OrderServiceImpl(){

  }

  @Override
  public List<Order> findByLikeObject(Order order) throws ServiceException {
    return null;
  }

  @Override
  public Optional<Order> findById(Long id) throws ServiceException {
    return Optional.empty();
  }

  @Override
  public Order save(Order order) throws ServiceException {
    return null;
  }

  @Override
  public Order update(Order order) throws ServiceException {
    return null;
  }

  @Override
  public Boolean delete(Order order) throws ServiceException {
    return null;
  }

}
