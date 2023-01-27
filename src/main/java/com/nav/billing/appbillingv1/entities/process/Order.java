package com.nav.billing.appbillingv1.entities.process;

import com.nav.billing.appbillingv1.entities.domain.Customer;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;

import static java.util.Objects.isNull;

// pedido cabecera
@Table(name = "ORDER")
@Entity(name = "Order")
public class Order {

  @Id
  @Column(name = "ID_ORDER")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOrder")
  @SequenceGenerator(sequenceName = "SEQ_ORDER", allocationSize = 1, name = "seqOrder")
  private Long orderId;

  //@NotNull(message = "El stock del producto es requerido")
  @Column(name = "TOTAL")
  @Positive(message = "El total debe ser un numero positivo")
  @Min(value = 1, message = "El total debe ser mayor o igual a {value}")
  private Double total;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "STATUS", length = 1, nullable = false)
  private String status;

  @ManyToOne
  @JoinColumn(name = "ID_CUSTOMER", nullable = false)
  private Customer customer;

  // Campo que se relaciona con ItemOrder
  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  @Where(clause = "status = '1'")
  private List<ItemOrder> items;

  //-este metodo puede ir en la capa de servicio como "Business logic"
  public void calculateTotal() {

    Double tmpTotal = 0.0;

    for (ItemOrder itemOrder : items) {
      if (isNull(items) || items.isEmpty() || isNull(itemOrder)) {
        setTotal(0.0);
      }
      tmpTotal += itemOrder.getTotal();
    }

    setTotal(tmpTotal);

  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<ItemOrder> getItems() {
    return items;
  }

  public void setItems(List<ItemOrder> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "Order{" +
        "orderId=" + orderId +
        ", total=" + total +
        ", description='" + description + '\'' +
        ", status='" + status + '\'' +
        ", customer=" + customer +
        ", items=" + items +
        '}';
  }

}
