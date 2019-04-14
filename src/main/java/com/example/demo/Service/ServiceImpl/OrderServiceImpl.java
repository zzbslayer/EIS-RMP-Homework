package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.OrderDao;
import com.example.demo.Domain.Entity.OrderEntity;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    @Override
    public OrderEntity getOrderById(long id) {
        return orderDao.getById(id);
    }

    @Override
    public OrderEntity createOrder(OrderEntity orderEntity) {
        return orderDao.create(orderEntity);
    }

    @Override
    public OrderEntity modifyOrder(long id, OrderEntity orderEntity) {
        return orderDao.modify(id, orderEntity);
    }

    @Override
    public List<OrderEntity> getAll() {
        return orderDao.getAll();
    }
}
