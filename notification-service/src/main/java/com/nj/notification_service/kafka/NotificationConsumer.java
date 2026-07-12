package com.nj.notification_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nj.notification_service.event.OrderCreatedEvent;

@Component
public class NotificationConsumer {

    @KafkaListener(
            topics = "order-created",
            groupId = "notification-group"
    )
    public void consume(OrderCreatedEvent event) {

        System.out.println("========================================");
        System.out.println("Notification generated");
        System.out.println("Order ID : " + event.getOrderId());
        System.out.println("Product  : " + event.getProductName());
        System.out.println("Quantity : " + event.getQuantity());
        System.out.println("Price    : " + event.getPrice());
        System.out.println("Message  : Order placed successfully");
        System.out.println("========================================");
    }
}