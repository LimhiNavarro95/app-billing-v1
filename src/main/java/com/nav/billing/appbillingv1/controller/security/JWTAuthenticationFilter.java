package com.nav.billing.appbillingv1.controller.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nav.billing.appbillingv1.entities.security.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  //@Autowired
  private JWTUtils jwtUtils;

  private AuthenticationManager authenticationManager;

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtils jwtUtils) {
    this.authenticationManager = authenticationManager;
    this.jwtUtils=jwtUtils;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {

    try {

      System.out.println("usuario json " + request.getInputStream());

      UsuarioEntity usuario = new ObjectMapper().readValue(request.getInputStream(), UsuarioEntity.class);

      System.out.println("usuario " + usuario);

      UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(usuario.getUsuario(),
          usuario.getClave(), new ArrayList<>());

      System.out.println("upat" + upat);

      Authentication aut = authenticationManager.authenticate(upat);

      // System.out.println("aut "+aut);

      return aut;

    } catch (IOException e) {
      System.out.println("attemptAuthentication " + e.getMessage());
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                          Authentication auth) throws IOException, ServletException {

		/*
		byte signingKey[] = Constants.SUPER_SECRET_KEY.getBytes();


		String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(Constants.ISSUER_INFO)
				.setSubject(((UserDetailsImpl) auth.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + Constants.TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, signingKey).compact();
		*/
    String token = jwtUtils.generateJwtToken(auth);

		/*
		Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
		.setExpiration(new Date((new Date()).getTime() + Constants.TOKEN_EXPIRATION_TIME))
		.signWith(SignatureAlgorithm.HS512, Constants.SUPER_SECRET_KEY).compact();
		*/

    System.out.println("token " + token);

    response.addHeader("Access-Control-Expose-Headers", "Authorization");

    response.addHeader(Constants.HEADER_AUTHORIZACION_KEY, Constants.TOKEN_BEARER_PREFIX + " " + token);

  }

}
