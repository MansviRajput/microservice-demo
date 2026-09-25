package org.ts.ecomorderservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.ts.ecomorderservice.exception.ProductNotFoundException;
import org.ts.ecomorderservice.model.Order;
import org.ts.ecomorderservice.model.Product;

import java.util.UUID;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    private static final String PRODUCT_SERVICE_URL = "http://localhost:8081/product";

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Order placeOrder(String productId) {
        // Synchronous call: order-service BLOCKS here until product-service
        // responds (or times out, per the RestConfig timeouts).
        Product product = restTemplate.getForObject(
                PRODUCT_SERVICE_URL + "/" + productId,
                Product.class
        );

        if (product == null) {
            throw new ProductNotFoundException(productId);
        }

        Order order = new Order(
                UUID.randomUUID().toString(),
                product.getId(),
                product.getName(),
                product.getPrice(),
                "PLACED"
        );

        // In a real app: save `order` to order-service's own database here.
        return order;
    }
}
