package com.nav.billing.appbillingv1.service.process.insurance;

import com.nav.billing.appbillingv1.entities.process.InsurancePolicy;
import com.nav.billing.appbillingv1.repository.process.InsurancePolicyRepository;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsurancePolicyImpl implements InsurancePolicyService{

  private final InsurancePolicyRepository insurancePolicyRepository;

  public InsurancePolicyImpl(InsurancePolicyRepository insurancePolicyRepository) {
    this.insurancePolicyRepository = insurancePolicyRepository;
  }

  @Override
  public List<InsurancePolicy> findByLikeObject(InsurancePolicy insurancePolicy) throws ServiceException {
    return null;
  }

  @Override
  public Optional<InsurancePolicy> findById(Long id) throws ServiceException {
    try{
      return insurancePolicyRepository.findInsurancePolicyById(id);
    } catch (Exception e){
      throw new ServiceException(e);
    }
  }

  /* TODO arreglar consulta
  @Override
  public List<InsurancePolicy> findInsurancePoliciesByCustomer(Long id) throws ServiceException {
    try {
      return insurancePolicyRepository.findInsurancePoliciesByCustomer(id);
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }*/

  @Override
  public InsurancePolicy save(InsurancePolicy insurancePolicy) throws ServiceException {
    try {
      //se hace el guardado con datos ya listos en el objeto
      return insurancePolicyRepository.save(insurancePolicy);
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public InsurancePolicy update(InsurancePolicy insurancePolicy) throws ServiceException {
    return null;
  }

  @Override
  public Boolean delete(InsurancePolicy insurancePolicy) throws ServiceException {
    return null;
  }

}
