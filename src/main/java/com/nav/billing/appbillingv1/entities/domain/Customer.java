package com.nav.billing.appbillingv1.entities.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "CUSTOMER")
@Entity(name = "Customer")
public class Customer {

  @Id
  @Column(name = "ID_CUSTOMER")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCustomer")
  @SequenceGenerator(sequenceName = "SEQ_CUSTOMER", allocationSize = 1, name = "seqCustomer")
  private Long customerId;

  @NotNull(message = "El nombre del cliente es requerido")
  @Size(min = 5, max = 64, message = "El nombre debe tener como mínimo {min} y máximo {max} caracteres")
  @Column(name = "NAME", length = 64, nullable=false)
  private String customerName;

  @NotNull(message = "El apellido paterno del cliente es requerido")
  @Size(min = 5, max = 64, message="El apellido paterno debe tener como mínimo {min} y máximo {max} caracteres")
  @Column(name = "FIRST_NAME", length = 64, nullable=false)
  private String customerFirstName;

  @NotNull(message = "El apellido materno del cliente es requerido")
  @Size(min = 5, max = 64, message="El apellido materno debe tener como mínimo {min} y máximo {max} caracteres")
  @Column(name = "SECOND_NAME", length = 64, nullable=false)
  private String customerSecondName;

  @NotNull(message = "La razon social del cliente es requerido")
  @Size(min = 5, max = 64, message="La razon social debe tener como mínimo {min} y máximo {max} caracteres")
  @Column(name = "BUSINESS_NAME", length = 64, nullable=false)
  private String businessName; //razon social

  @NotNull(message = "El telefono del cliente es requerido")
  @Size(min = 5, max = 32, message="El telefono debe tener como mínimo {min} y máximo {max} caracteres")
  @Column(name = "PHONE", length = 32, nullable=false)
  private String customerPhone;

  @NotNull(message = "La direccion del cliente es requerida")
  @Size(min = 5, max = 128, message="La direccion debe tener como mínimo {min} y máximo {max} caracteres")
  @Column(name = "ADDRESS", length = 128, nullable=false)
  private String customerAddress;

  @NotNull(message = "El RFC del cliente es requerido")
  @Size(min = 5, max = 32, message="El RFC debe tener como mínimo {min} y máximo {max} caracteres")
  @Column(name = "RFC",length = 32, nullable=false)
  private String rfc;

  @Column(name = "STATUS", length = 1, nullable = false)
  private String status;

  public Customer(Long customerId, String customerName, String customerFirstName, String customerSecondName, String businessName, String customerPhone, String customerAddress, String rfc, String status) {
    this.customerId = customerId;
    this.customerName = customerName;
    this.customerFirstName = customerFirstName;
    this.customerSecondName = customerSecondName;
    this.businessName = businessName;
    this.customerPhone = customerPhone;
    this.customerAddress = customerAddress;
    this.rfc = rfc;
    this.status = status;
  }

  public Customer() {
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerFirstName() {
    return customerFirstName;
  }

  public void setCustomerFirstName(String customerFirstName) {
    this.customerFirstName = customerFirstName;
  }

  public String getCustomerSecondName() {
    return customerSecondName;
  }

  public void setCustomerSecondName(String customerSecondName) {
    this.customerSecondName = customerSecondName;
  }

  public String getBusinessName() {
    return businessName;
  }

  public void setBusinessName(String businessName) {
    this.businessName = businessName;
  }

  public String getCustomerPhone() {
    return customerPhone;
  }

  public void setCustomerPhone(String customerPhone) {
    this.customerPhone = customerPhone;
  }

  public String getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
  }

  public String getRfc() {
    return rfc;
  }

  public void setRfc(String rfc) {
    this.rfc = rfc;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "customerId=" + customerId +
        ", customerName='" + customerName + '\'' +
        ", customerFirstName='" + customerFirstName + '\'' +
        ", customerSecondName='" + customerSecondName + '\'' +
        ", businessName='" + businessName + '\'' +
        ", customerPhone='" + customerPhone + '\'' +
        ", customerAddress='" + customerAddress + '\'' +
        ", rfc='" + rfc + '\'' +
        ", status='" + status + '\'' +
        '}';
  }

}
