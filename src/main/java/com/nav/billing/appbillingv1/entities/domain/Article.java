package com.nav.billing.appbillingv1.entities.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Table(name = "ARTICLE")
@Entity(name = "Article")
public class Article {

  @Id
  @Column(name = "ID_ARTICLE")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqArticle")
  @SequenceGenerator(sequenceName = "SEQ_ARTICLE", allocationSize = 1, name = "seqArticle")
  private Long articleId;

  @NotNull(message = "La marca del producto es requerida")
  @Size(min = 5, max = 32, message = "La marca debe tener como mínimo {min} y máximo {max} caracteres")
  @Column(name = "TRADEMARK", length = 32, nullable = false)
  private String trademark;

  @NotNull(message = "La descripcion del producto es requerida")
  @Size(min = 5, max = 128, message = "La descripcion debe tener como mínimo {min} y máximo {max} caracteres")
  @Column(name = "DESCRIPTION", length = 128, nullable = false)
  private String description;

  @NotNull(message = "El precio del producto es requerido")
  @Column(name = "PRICE")
  @Positive(message = "El precio debe ser un numero positivo")
  @Min(value = 1, message = "El precio debe ser mayor o igual a {value}")
  private Double price;

  @NotNull(message = "El stock del producto es requerido")
  @Column(name = "STOCK")
  @Positive(message = "El stock debe ser un numero positivo")
  @Min(value = 1, message = "El stock debe ser mayor o igual a {value}")
  private Double stock;

  @Column(name = "STATUS", length = 1, nullable = false)
  private String status;

  public Long getArticleId() {
    return articleId;
  }

  public void setArticleId(Long articleId) {
    this.articleId = articleId;
  }

  public String getTrademark() {
    return trademark;
  }

  public void setTrademark(String trademark) {
    this.trademark = trademark;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getStock() {
    return stock;
  }

  public void setStock(Double stock) {
    this.stock = stock;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Article{" +
        "articleId=" + articleId +
        ", trademark='" + trademark + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", stock=" + stock +
        ", status='" + status + '\'' +
        '}';
  }

}
