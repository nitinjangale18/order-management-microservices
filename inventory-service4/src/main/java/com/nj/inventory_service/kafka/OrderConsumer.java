package com.nj.inventory_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nj.inventory_service.event.OrderCreatedEvent;
import com.nj.inventory_service.service.InventoryService;

@Component
public class OrderConsumer {

    private final InventoryService inventoryService;

    public OrderConsumer(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @KafkaListener(topics = "order-created", groupId = "inventory-group")
    public void consume(OrderCreatedEvent event) {

        System.out.println("========================================");
        System.out.println("Order Received");
        System.out.println("Order ID : " + event.getOrderId());
        System.out.println("Product  : " + event.getProductName());
        System.out.println("Quantity : " + event.getQuantity());

        inventoryService.reduceStock(
                event.getProductName(),
                event.getQuantity());

        System.out.println("Inventory Updated Successfully");
        System.out.println("========================================");
    }
}