package com.nj.order.service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.nj.order.service.event.OrderCreatedEvent;

@Component
public class OrderProducer {

    private static final String TOPIC = "order-created";

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrder(OrderCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
