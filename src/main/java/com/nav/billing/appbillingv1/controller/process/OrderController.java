package com.nav.billing.appbillingv1.controller.process;

import com.nav.billing.appbillingv1.entities.process.Order;
import com.nav.billing.appbillingv1.service.process.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import com.nav.billing.appbillingv1.util.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.nav.billing.appbillingv1.commons.GlobalConstants.ORDER_API;
import static java.util.Objects.isNull;

@RestController
@Slf4j
@RequestMapping(ORDER_API)  // uri -> /v1/order
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id){

    try {
      Optional<Order> optionalOrder = orderService.findById(id);
      if (optionalOrder.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return  ResponseEntity.ok(optionalOrder.get());
    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody  @Validated Order order, BindingResult result){

    if (result.hasErrors()) {
      return WebUtil.getErrors(result);
    }

    try {
      Order objOrder = orderService.save(order);
      if (isNull(objOrder)) {
        return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.status(HttpStatus.CREATED).body(objOrder);
    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

}
