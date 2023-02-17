package com.nav.billing.appbillingv1.entities.security;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_AUTHORITY")
@ToString
@Data
@NoArgsConstructor
public class AuthorityEntity{

  @Id
  @Column(name = "AUTHORITY_ID")
  private Long id = 0L;

  @Column(name = "NOMBRE")
  private String nombre = "";

}
