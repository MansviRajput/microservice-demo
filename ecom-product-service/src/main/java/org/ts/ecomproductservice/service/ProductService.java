package org.ts.ecomproductservice.service;

import org.springframework.stereotype.Service;
import org.ts.ecomproductservice.model.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductService {

    // In-memory "database" for now — swap for a real repository later
    private final Map<String, Product> productStore = new ConcurrentHashMap<>();

    public ProductService() {
        productStore.put("1", new Product("1", "Wireless Mouse", 499.0, 50));
        productStore.put("2", new Product("2", "Mechanical Keyboard", 2999.0, 20));
    }

    public Product getProductById(String id) {
        return productStore.get(id); // returns null if not found — controller decides what that means
    }
}
