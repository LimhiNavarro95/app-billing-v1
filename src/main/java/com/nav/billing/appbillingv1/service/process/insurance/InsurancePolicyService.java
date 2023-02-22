package com.nav.billing.appbillingv1.service.process.insurance;

import com.nav.billing.appbillingv1.entities.process.InsurancePolicy;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import com.nav.billing.appbillingv1.service.generic.GenericService;

import java.util.List;

public interface InsurancePolicyService extends GenericService<InsurancePolicy> {

  List<InsurancePolicy> findInsurancePoliciesByCustomer(Long customerId) throws ServiceException;

}
