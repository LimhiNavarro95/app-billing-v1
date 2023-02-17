package com.nav.billing.appbillingv1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class GlobalConfiguration {

  //@Bean
  /*public WebMvcConfigurer corsConfigurer() {

    return new WebMvcConfigurer() {

      @Override
      public void addCorsMappings(CorsRegistry registry) {

        System.out.println("addCorsMappings...");
        registry
            .addMapping("/**")
            .allowedOrigins("*") // http://localhost:4200
            .allowedMethods("*")//GET", "POST
            .allowedHeaders("*")
            .exposedHeaders("*");

      }
    };
  }*/

}
