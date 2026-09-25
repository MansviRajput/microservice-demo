package org.ts.ecomorderservice.model;

public class Order {

    private String orderId;
    private String productId;
    private String productName;
    private double totalPrice;
    private String status;

    public Order() {
    }

    public Order(String orderId, String productId, String productName, double totalPrice, String status) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
