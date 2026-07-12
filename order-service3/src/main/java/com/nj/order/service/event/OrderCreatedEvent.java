package com.nj.order.service.event;

public class OrderCreatedEvent {

    private Long orderId;
    private String productName;
    private Integer quantity;
    private Double price;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(Long orderId, String productName, Integer quantity, Double price) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}