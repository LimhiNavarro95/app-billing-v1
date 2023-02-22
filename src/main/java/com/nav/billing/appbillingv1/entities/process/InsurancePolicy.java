package com.nav.billing.appbillingv1.entities.process;

import com.nav.billing.appbillingv1.entities.domain.Customer;

import javax.persistence.*;

@Table(name = "INSURANCE_POLICY")
@Entity(name = "InsurancePolicy")
public class InsurancePolicy {

  @Id
  @Column(name = "ID_INSURANCE_POLICY")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqInsurancePolicy")
  @SequenceGenerator(sequenceName = "SEQ_INSURANCE_POLICY", allocationSize = 1, name = "seqInsurancePolicy")
  private Long insurancePolicyId;

  @ManyToOne
  @JoinColumn(name = "ID_CUSTOMER", nullable = false)
  private Customer customer;

  @Column(name = "TOTAL_INSURANCE_AMOUNT")
  private Long totalInsuranceAmount;

  @Column(name = "VEHICLE_NAME")
  private String vehicleName;

  @Column(name = "VEHICLE_MODEL")
  private String vehicleModel; //anio del vehiculo

  @Column(name = "CAR_PLATES")
  private String carPlates; //placas

  @Column(name = "START_DATE")
  private String startDate;

  @Column(name = "END_DATE")
  private String endDate;

  @OneToOne
  @JoinColumn(name = "ID_INSURANCE_COVERAGE")
  private InsuranceCoverage insuranceCoverage;

  @Column(name = "STATUS", length = 1, nullable = false)
  private String status;

  public InsurancePolicy(Long insurancePolicyId, Customer customer, Long totalInsuranceAmount, String vehicleName, String vehicleModel, String carPlates, String startDate, String endDate, InsuranceCoverage insuranceCoverage, String status) {
    this.insurancePolicyId = insurancePolicyId;
    this.customer = customer;
    this.totalInsuranceAmount = totalInsuranceAmount;
    this.vehicleName = vehicleName;
    this.vehicleModel = vehicleModel;
    this.carPlates = carPlates;
    this.startDate = startDate;
    this.endDate = endDate;
    this.insuranceCoverage = insuranceCoverage;
    this.status = status;
  }

  public InsurancePolicy() {
  }

  public Long getInsurancePolicyId() {
    return insurancePolicyId;
  }

  public void setInsurancePolicyId(Long insurancePolicyId) {
    this.insurancePolicyId = insurancePolicyId;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Long getTotalInsuranceAmount() {
    return totalInsuranceAmount;
  }

  public void setTotalInsuranceAmount(Long totalInsuranceAmount) {
    this.totalInsuranceAmount = totalInsuranceAmount;
  }

  public String getVehicleName() {
    return vehicleName;
  }

  public void setVehicleName(String vehicleName) {
    this.vehicleName = vehicleName;
  }

  public String getVehicleModel() {
    return vehicleModel;
  }

  public void setVehicleModel(String vehicleModel) {
    this.vehicleModel = vehicleModel;
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

  public InsuranceCoverage getInsuranceCoverage() {
    return insuranceCoverage;
  }

  public void setInsuranceCoverage(InsuranceCoverage insuranceCoverage) {
    this.insuranceCoverage = insuranceCoverage;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "InsurancePolicy{" +
        "insurancePolicyId=" + insurancePolicyId +
        ", customer=" + customer +
        ", totalInsuranceAmount=" + totalInsuranceAmount +
        ", vehicleName='" + vehicleName + '\'' +
        ", vehicleModel='" + vehicleModel + '\'' +
        ", carPlates='" + carPlates + '\'' +
        ", startDate='" + startDate + '\'' +
        ", endDate='" + endDate + '\'' +
        ", insuranceCoverage=" + insuranceCoverage +
        ", status='" + status + '\'' +
        '}';
  }

}
