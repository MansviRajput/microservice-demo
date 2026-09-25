package org.ts.ecomorderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Thrown by RestTemplate when product-service itself returns a 4xx (e.g. 404)
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleDownstreamClientError(HttpClientErrorException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                .body("product-service rejected the request: " + ex.getMessage());
    }

    // Thrown when product-service is down / unreachable / times out
    @ExceptionHandler(org.springframework.web.client.ResourceAccessException.class)
    public ResponseEntity<String> handleDownstreamUnavailable(Exception ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("product-service is unavailable right now. Please try again shortly.");
    }
}
