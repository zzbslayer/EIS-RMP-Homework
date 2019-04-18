package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.OrderDao;
import com.example.demo.Domain.Entity.OrderEntity;
import com.example.demo.Service.OrderService;
import com.example.demo.Utility.Geography.Geohash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<OrderEntity> getNearbyOrders(double longitude, double latitude) {
        String base = Geohash.geohash(longitude, latitude, Geohash.DEFAULT_LENGTH);
        List<OrderEntity> orders = getAll();
        List<OrderEntity> res =
                orders
                        .stream()
                        .filter((e) ->
                                (Geohash.match(base, e.getStore().getAddress().getGeohash(), Geohash.DEFAULT_MATCH_LENGTH)
                                && e.getStatus() == OrderEntity.Status.WAITING)
                        )
                        .sorted((a, b) -> {
                                    double a_distance = orderDistance(longitude, latitude, a);
                                    double b_distance = orderDistance(longitude, latitude, b);
                                    if (a_distance < b_distance)
                                        return -1;
                                    else
                                        return 1;
                                }
                        )
                        .collect(Collectors.toList());
        return res;
    }

    private static double orderDistance(double x1, double y1, OrderEntity o){
        return distance(x1, y1, o.getStore().getAddress().getLongitude(), o.getStore().getAddress().getLatitude());
    }
    private static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow((x1- x2), 2) + Math.pow(y1-y2, 2));
    }

    @Override
    public List<OrderEntity> getOrdersByUserId(long id) {
        List<OrderEntity> orders = getAll();
        List<OrderEntity> res =
                orders
                        .stream()
                        .filter((e) ->
                                (e.getBuyer().getId() == id)
                        )
                        .collect(Collectors.toList());
        return res;
    }
}
