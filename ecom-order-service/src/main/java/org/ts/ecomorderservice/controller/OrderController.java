package org.ts.ecomorderservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ts.ecomorderservice.model.Order;
import org.ts.ecomorderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{pid}")
    public ResponseEntity<Order> placeOrder(@PathVariable String pid) {
        Order order = orderService.placeOrder(pid);
        return ResponseEntity.ok(order);
    }
}
