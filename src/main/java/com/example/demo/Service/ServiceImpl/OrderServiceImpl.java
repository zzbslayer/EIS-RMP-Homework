package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.AddressDao;
import com.example.demo.Dao.DaoImpl.OrderDao;
import com.example.demo.Domain.Entity.AddressEntity;
import com.example.demo.Domain.Entity.OrderEntity;
import com.example.demo.Domain.Entity.StoreEntity;
import com.example.demo.Domain.Entity.UserEntity;
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
    @Autowired
    private AddressDao addressDao;

    @Override
    public OrderEntity getById(long id) {
        return orderDao.getById(id);
    }

    @Override
    public OrderEntity create(OrderEntity orderEntity, boolean createAddress) {
        if (createAddress){
            AddressEntity addressEntity = addressDao.create(orderEntity.getAddress());
            orderEntity.setAddress(addressEntity);
        }
        return orderDao.create(orderEntity);
    }

    @Override
    public OrderEntity modify(long id, OrderEntity orderEntity) {
        return orderDao.modify(id, orderEntity);
    }

    @Override
    public List<OrderEntity> getAll() {
        return orderDao.getAll();
    }

    @Override
    public List<OrderEntity> getNearby(double longitude, double latitude) {
        String base = Geohash.geohash(longitude, latitude, Geohash.DEFAULT_LENGTH);
        List<OrderEntity> orders = getAll();
        List<OrderEntity> res =
                orders
                        .stream()
                        .filter((e) -> {
                            AddressEntity addressEntity = e.getAddress();
                            if (addressEntity == null)
                                return false;
                            return Geohash.match(base, addressEntity.getGeohash(), Geohash.DEFAULT_MATCH_LENGTH)
                                    && e.getOrderstatus() == OrderEntity.Status.WAITING;
                        })
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
        return distance(x1, y1, o.getAddress().getLongitude(), o.getAddress().getLatitude());
    }
    private static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow((x1- x2), 2) + Math.pow(y1-y2, 2));
    }

    @Override
    public List<OrderEntity> getByUserId(long id) {
        List<OrderEntity> orders = getAll();
        List<OrderEntity> res =
                orders
                        .stream()
                        .filter((e) -> {
                            UserEntity userEntity = e.getGoumai();
                            if (userEntity == null)
                                return false;
                            return userEntity.getId() == id;
                        })
                        .collect(Collectors.toList());
        return res;
    }

    @Override
    public List<OrderEntity> getByProxyId(long id) {
        List<OrderEntity> orders = getAll();
        List<OrderEntity> res =
                orders
                        .stream()
                        .filter((e) -> {
                            UserEntity userEntity = e.getDaigou();
                            if (userEntity == null)
                                return false;
                            return userEntity.getId() == id && e.getOrderstatus() == OrderEntity.Status.BUYING;
                        })
                        .collect(Collectors.toList());
        return res;
    }
}
