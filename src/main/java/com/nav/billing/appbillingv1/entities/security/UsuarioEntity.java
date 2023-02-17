package com.nav.billing.appbillingv1.entities.security;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TBL_USUARIO")
public class UsuarioEntity {

  @Id
  @Column(name = "ID_USUARIO")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsuario")
  @SequenceGenerator(sequenceName = "SEQ_USUARIO", allocationSize = 1, name = "seqUsuario")
  private Long id;

  @NotNull(message = "El usuario es requerido")
  @Size(min = 3, max = 20, message = "El usuario debe tener como mínimo {min} y {max} caracteres")
  @Column(name = "USUARIO")
  private String usuario;

  @NotNull(message = "La clave es requerida")
  @Size(min = 6, max = 20, message = "La clave debe tener como mínimo {min} y {max} caracteres")
  @Column(name = "CLAVE")
  private String clave;

  @NotNull(message = "El nombre corto es requerido")
  @Size(min = 10, max = 120, message = "El nombre corto debe tener como mínimo {min} y {max} caracteres")
  @Column(name = "NOMBRE")
  private String nombre;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "TBL_USUARIO_AUTHORITY",
      joinColumns = { @JoinColumn(name = "ID_USUARIO") },
      inverseJoinColumns = { @JoinColumn(name = "AUTHORITY_ID") }
  )
  private Set<AuthorityEntity> authorities = new HashSet<>();

  public UsuarioEntity(String usuario, String nombre, String clave){
    this.usuario = usuario;
    this.nombre = nombre;
    this.clave = clave;
  }

}