package com.nav.billing.appbillingv1.repository.process;

import com.nav.billing.appbillingv1.entities.process.InsuranceCoverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsuranceCoverageRepository extends JpaRepository<InsuranceCoverage, Long> {

  @Query("select insCov from InsuranceCoverage insCov where insCov.coverageName = :coverageName")
  Optional<InsuranceCoverage> findInsuranceCoverageByCoverageName(@Param("coverageName") String coverageName);

}
