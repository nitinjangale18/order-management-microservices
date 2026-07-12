package com.nj.order.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nj.order.service.entity.Order;
import com.nj.order.service.event.OrderCreatedEvent;
import com.nj.order.service.kafka.OrderProducer;
import com.nj.order.service.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;

    public OrderService(
            OrderRepository orderRepository,
            OrderProducer orderProducer) {

        this.orderRepository = orderRepository;
        this.orderProducer = orderProducer;
    }

    public Order saveOrder(Order order) {

        Order savedOrder = orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(
                savedOrder.getId(),
                savedOrder.getProductName(),
                savedOrder.getQuantity(),
                savedOrder.getPrice()
        );

        orderProducer.publishOrder(event);

        return savedOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}