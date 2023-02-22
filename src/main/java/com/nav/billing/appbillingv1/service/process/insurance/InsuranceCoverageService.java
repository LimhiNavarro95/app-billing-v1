package com.nav.billing.appbillingv1.service.process.insurance;

import com.nav.billing.appbillingv1.entities.process.InsuranceCoverage;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import com.nav.billing.appbillingv1.service.generic.GenericService;

import java.util.Optional;

public interface InsuranceCoverageService extends GenericService<InsuranceCoverage> {

  Optional<InsuranceCoverage> findInsuranceCoverageByCoverageName(String coverageName) throws ServiceException;

}
