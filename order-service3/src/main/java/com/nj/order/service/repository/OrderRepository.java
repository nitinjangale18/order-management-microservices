package com.nj.order.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nj.order.service.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}