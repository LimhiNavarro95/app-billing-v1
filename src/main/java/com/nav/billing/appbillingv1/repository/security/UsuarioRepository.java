package com.nav.billing.appbillingv1.repository.security;

import com.nav.billing.appbillingv1.entities.security.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

  UsuarioEntity findByUsuario(String usuario);

}
