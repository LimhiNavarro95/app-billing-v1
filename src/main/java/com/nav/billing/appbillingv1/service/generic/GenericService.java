package com.nav.billing.appbillingv1.service.generic;

import com.nav.billing.appbillingv1.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz con metodos genericos y comunes para servicio de transacciones de datos para ser heredadas a interfaces y no repetir el mismo codigo
 * @param <T> -> Tipo de objeto, ej: Customer
 */
public interface GenericService<T> {

  List<T> findByLikeObject(T t) throws ServiceException;

  Optional<T> findById(Long id) throws ServiceException;

  T save(T t) throws ServiceException;

  T update(T t) throws ServiceException;

  Boolean delete(T t) throws ServiceException;

}
