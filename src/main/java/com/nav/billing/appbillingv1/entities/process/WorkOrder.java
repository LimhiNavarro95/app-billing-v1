package com.nav.billing.appbillingv1.entities.process;

import com.nav.billing.appbillingv1.entities.domain.Customer;

/**
 * Objeto simple
 */
public class WorkOrder {

  private Long insurancePolicyId;
  private Long totalInsuranceAmount;
  private Long customerId;
  private String vehicleName;
  private String model;
  private String carPlates;
  private String startDate;
  private String endDate;
  private String insuranceCoverageName;

  public WorkOrder(Long insurancePolicyId, Long totalInsuranceAmount, Long customerId, String vehicleName, String model, String carPlates, String startDate, String endDate, String insuranceCoverageName) {
    this.insurancePolicyId = insurancePolicyId;
    this.totalInsuranceAmount = totalInsuranceAmount;
    this.customerId = customerId;
    this.vehicleName = vehicleName;
    this.model = model;
    this.carPlates = carPlates;
    this.startDate = startDate;
    this.endDate = endDate;
    this.insuranceCoverageName = insuranceCoverageName;
  }

  public WorkOrder() {
  }

  public Long getInsurancePolicyId() {
    return insurancePolicyId;
  }

  public void setInsurancePolicyId(Long insurancePolicyId) {
    this.insurancePolicyId = insurancePolicyId;
  }

  public Long getTotalInsuranceAmount() {
    return totalInsuranceAmount;
  }

  public void setTotalInsuranceAmount(Long totalInsuranceAmount) {
    this.totalInsuranceAmount = totalInsuranceAmount;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomer(Long customerId) {
    this.customerId = customerId;
  }

  public String getVehicleName() {
    return vehicleName;
  }

  public void setVehicleName(String vehicleName) {
    this.vehicleName = vehicleName;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getCarPlates() {
    return carPlates;
  }

  public void setCarPlates(String carPlates) {
    this.carPlates = carPlates;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getInsuranceCoverageName() {
    return insuranceCoverageName;
  }

  public void setInsuranceCoverageName(String insuranceCoverageName) {
    this.insuranceCoverageName = insuranceCoverageName;
  }

  @Override
  public String toString() {
    return "WorkOrder{" +
        "insurancePolicyId=" + insurancePolicyId +
        ", totalInsuranceAmount=" + totalInsuranceAmount +
        ", customerId=" + customerId +
        ", vehicleName='" + vehicleName + '\'' +
        ", model='" + model + '\'' +
        ", carPlates='" + carPlates + '\'' +
        ", startDate='" + startDate + '\'' +
        ", endDate='" + endDate + '\'' +
        ", insuranceCoverageName='" + insuranceCoverageName + '\'' +
        '}';
  }

}
