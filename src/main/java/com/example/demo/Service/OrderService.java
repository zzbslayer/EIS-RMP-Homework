package com.example.demo.Service;

import com.example.demo.Domain.Entity.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderEntity getById(long id);

    OrderEntity create(OrderEntity orderEntity, boolean createAddress);

    OrderEntity modify(long id, OrderEntity orderEntity);

    List<OrderEntity> getAll();

    List<OrderEntity> getNearby(double longitude, double latitude);

    List<OrderEntity> getByUserId(long id);
}
