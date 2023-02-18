package com.nav.billing.appbillingv1.service.security;

import static java.util.Objects.*;
import static java.util.Collections.emptyList;

import com.nav.billing.appbillingv1.entities.security.UsuarioEntity;
import com.nav.billing.appbillingv1.repository.security.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

/* Spring Security	*/

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

  @Autowired
  UsuarioRepository usuarioRepository;

  /*public UserDetailsServiceImpl(UsuarioRepository usuarioRepository){
    this.usuarioRepository = usuarioRepository;
  }*/

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UsuarioEntity usuarioEntity = this.usuarioRepository.findByUsuario(username);
    //UsuarioEntity usuarioEntity= usuarioRepository.findByUsuario(username);

    if (isNull(usuarioEntity)) {
      throw new UsernameNotFoundException("Usuario no existe");
    }

    //return new UserDetailsImpl(usuarioEntity);

    return new User(usuarioEntity.getUsuario(),usuarioEntity.getClave(),emptyList());

  }

}