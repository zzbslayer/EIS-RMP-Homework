package com.example.demo.Service;

import com.example.demo.Domain.Entity.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderEntity getOrderById(long id);

    OrderEntity createOrder(OrderEntity orderEntity);

    OrderEntity modifyOrder(long id, OrderEntity orderEntity);

    List<OrderEntity> getAll();
}
