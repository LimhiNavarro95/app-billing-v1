package com.nav.billing.appbillingv1.entities.process;

import javax.persistence.*;

@Table(name = "INSURANCE_COVERAGE")
@Entity(name = "InsuranceCoverage")
public class InsuranceCoverage {

  @Id
  @Column(name = "ID_INSURANCE_COVERAGE")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqInsuranceCoverage")
  @SequenceGenerator(sequenceName = "SEQ_INSURANCE_COVERAGE", allocationSize = 1, name = "seqInsuranceCoverage")
  private Long insuranceCoverageId;

  @Column(name = "COVERAGE_NAME")
  private String coverageName;

  @Column(name = "FIRST_COVERAGE_DESCRIPTION")
  private String firstCoverageDescription;

  @Column(name = "FIRST_COVERAGE_AMOUNT")
  private Long firstCoverageAmount;

  @Column(name = "SECOND_COVERAGE_DESCRIPTION")
  private String secondCoverageDescription;

  @Column(name = "SECOND_COVERAGE_AMOUNT")
  private Long secondCoverageAmount;

  @Column(name = "THIRD_COVERAGE_DESCRIPTION")
  private String thirdCoverageDescription;

  @Column(name = "THIRD_COVERAGE_AMOUNT")
  private Long thirdCoverageAmount;

  public Long getInsuranceCoverageId() {
    return insuranceCoverageId;
  }

  public InsuranceCoverage(Long insuranceCoverageId, String coverageName, String firstCoverageDescription, Long firstCoverageAmount, String secondCoverageDescription, Long secondCoverageAmount, String thirdCoverageDescription, Long thirdCoverageAmount) {
    this.insuranceCoverageId = insuranceCoverageId;
    this.coverageName = coverageName;
    this.firstCoverageDescription = firstCoverageDescription;
    this.firstCoverageAmount = firstCoverageAmount;
    this.secondCoverageDescription = secondCoverageDescription;
    this.secondCoverageAmount = secondCoverageAmount;
    this.thirdCoverageDescription = thirdCoverageDescription;
    this.thirdCoverageAmount = thirdCoverageAmount;
  }

  public InsuranceCoverage() {
  }

  public void setInsuranceCoverageId(Long insuranceCoverageId) {
    this.insuranceCoverageId = insuranceCoverageId;
  }

  public String getFirstCoverageDescription() {
    return firstCoverageDescription;
  }

  public String getCoverageName() {
    return coverageName;
  }

  public void setCoverageName(String coverageName) {
    this.coverageName = coverageName;
  }

  public void setFirstCoverageDescription(String firstCoverageDescription) {
    this.firstCoverageDescription = firstCoverageDescription;
  }

  public Long getFirstCoverageAmount() {
    return firstCoverageAmount;
  }

  public void setFirstCoverageAmount(Long firstCoverageAmount) {
    this.firstCoverageAmount = firstCoverageAmount;
  }

  public String getSecondCoverageDescription() {
    return secondCoverageDescription;
  }

  public void setSecondCoverageDescription(String secondCoverageDescription) {
    this.secondCoverageDescription = secondCoverageDescription;
  }

  public Long getSecondCoverageAmount() {
    return secondCoverageAmount;
  }

  public void setSecondCoverageAmount(Long secondCoverageAmount) {
    this.secondCoverageAmount = secondCoverageAmount;
  }

  public String getThirdCoverageDescription() {
    return thirdCoverageDescription;
  }

  public void setThirdCoverageDescription(String thirdCoverageDescription) {
    this.thirdCoverageDescription = thirdCoverageDescription;
  }

  public Long getThirdCoverageAmount() {
    return thirdCoverageAmount;
  }

  public void setThirdCoverageAmount(Long thirdCoverageAmount) {
    this.thirdCoverageAmount = thirdCoverageAmount;
  }

  @Override
  public String toString() {
    return "InsuranceCoverage{" +
        "insuranceCoverageId=" + insuranceCoverageId +
        ", coverageName='" + coverageName + '\'' +
        ", firstCoverageDescription='" + firstCoverageDescription + '\'' +
        ", firstCoverageAmount=" + firstCoverageAmount +
        ", secondCoverageDescription='" + secondCoverageDescription + '\'' +
        ", secondCoverageAmount=" + secondCoverageAmount +
        ", thirdCoverageDescription='" + thirdCoverageDescription + '\'' +
        ", thirdCoverageAmount=" + thirdCoverageAmount +
        '}';
  }

}
