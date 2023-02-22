package com.nav.billing.appbillingv1.service.process.insurance;

import com.nav.billing.appbillingv1.entities.process.InsuranceCoverage;
import com.nav.billing.appbillingv1.repository.process.InsuranceCoverageRepository;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceCoverageImpl implements InsuranceCoverageService{

  private final InsuranceCoverageRepository insuranceCoverageRepository;

  public InsuranceCoverageImpl(InsuranceCoverageRepository insuranceCoverageRepository) {
    this.insuranceCoverageRepository = insuranceCoverageRepository;
  }

  @Override
  public Optional<InsuranceCoverage> findInsuranceCoverageByCoverageName(String coverageName) throws ServiceException {
    try {
      return insuranceCoverageRepository.findInsuranceCoverageByCoverageName(coverageName);
    } catch (Exception e){
      throw new ServiceException(e);
    }
  }

  @Override
  public List<InsuranceCoverage> findByLikeObject(InsuranceCoverage insuranceCoverage) throws ServiceException {
    return null;
  }

  @Override
  public Optional<InsuranceCoverage> findById(Long id) throws ServiceException {
    try{
      return insuranceCoverageRepository.findById(id);
    } catch (Exception e){
      throw new ServiceException(e);
    }
  }

  @Override
  public InsuranceCoverage save(InsuranceCoverage insuranceCoverage) throws ServiceException {
    return null;
  }

  @Override
  public InsuranceCoverage update(InsuranceCoverage insuranceCoverage) throws ServiceException {
    return null;
  }

  @Override
  public Boolean delete(InsuranceCoverage insuranceCoverage) throws ServiceException {
    return null;
  }
}
