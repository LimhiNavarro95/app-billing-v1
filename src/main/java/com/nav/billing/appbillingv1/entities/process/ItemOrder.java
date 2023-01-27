package com.nav.billing.appbillingv1.entities.process;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nav.billing.appbillingv1.entities.domain.Article;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import static java.util.Objects.isNull;

// pedido detalle
@Table(name = "ITEM_ORDER")
@Entity(name = "ItemOrder")
public class ItemOrder {

  @Id
  @Column(name = "ID_ITEM_ORDER")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqItemOrder")
  @SequenceGenerator(sequenceName = "SEQ_ITEM_ORDER", allocationSize = 1, name = "seqItemOrder")
  private Long itemOrderId;

  @Column(name = "PRICE")
  @Positive(message = "El precio debe ser un numero positivo")
  @Min(value = 1, message = "El precio debe ser mayor o igual a {value}")
  private Double price;

  @Column(name = "QUANTITY")
  private Double quantity; //cantidad

  @Column(name = "TOTAL")
  @Positive(message = "El total debe ser un numero positivo")
  @Min(value = 1, message = "El total debe ser mayor o igual a {value}")
  private Double total;

  @Column(name = "STATUS", length = 1, nullable = false)
  private String status;

  @ManyToOne
  @JoinColumn(name = "ID_ARTICLE", nullable = false)
  private Article article;

  // Campo que se relaciona con Order
  //@JsonBackReference
  @JsonIgnore // Para evitar redundancias infinitas
  @ManyToOne
  @JoinColumn(name = "ID_ORDER", nullable = false)
  private Order order;

  //-este metodo puede ir en la capa de servicio como "Business logic"
  public void calculateSubTotal(){

    //validaciones para no multiplicar nulos, se evitan errores.
    if (isNull(quantity)) {
      quantity = 0.0;
    }
    if (isNull(price)) {
      price = 0.0;
    }

    setTotal(quantity * price);

  }

  public Long getItemOrderId() {
    return itemOrderId;
  }

  public void setItemOrderId(Long itemOrderId) {
    this.itemOrderId = itemOrderId;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  @Override
  public String toString() {
    return "ItemOrder{" +
        "itemOrderId=" + itemOrderId +
        ", price=" + price +
        ", quantity=" + quantity +
        ", total=" + total +
        ", status='" + status + '\'' +
        ", article=" + article +
        ", order=" + order +
        '}';
  }

}
