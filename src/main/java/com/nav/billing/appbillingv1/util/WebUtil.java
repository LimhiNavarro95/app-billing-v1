package com.nav.billing.appbillingv1.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WebUtil {

  public static ResponseEntity<List<Map<String, String>>> getErrors(BindingResult result) {
    List<Map<String, String>> errors = result.getFieldErrors().stream().map(err -> {
          Map<String, String> error = new HashMap<>();
          error.put(err.getField(), err.getDefaultMessage());
          return error;
        }
    ).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }

}
