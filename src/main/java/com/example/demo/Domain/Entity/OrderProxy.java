package com.example.demo.Domain.Entity;

import java.util.ArrayList;
import java.util.List;

public class OrderProxy {

    public static OrderProxy create(OrderEntity orderEntity){
        OrderProxy res = new OrderProxy();
        res.id = orderEntity.getId();
        res.address = orderEntity.getAddress();
        res.buyer = orderEntity.getGoumai();
        res.proxy = orderEntity.getDaigou();
        res.goods = orderEntity.getGoods();
        res.goodsprice = orderEntity.getGoodsprice();
        res.proxyprice = orderEntity.getProxyprice();
        res.modifiedtime = orderEntity.getShijian();
        res.recipient = orderEntity.getRecipientaddress();
        res.status = orderEntity.getOrderstatus();
        res.store = orderEntity.getStore();
        return res;
    }

    public static List<OrderProxy> create(List<OrderEntity> orderEntities){
        List<OrderProxy> res = new ArrayList<>();
        for (OrderEntity o: orderEntities){
            res.add(OrderProxy.create(o));
        }
        return res;
    }

    private long id;
    private UserEntity buyer;
    private UserEntity proxy;
    private RecipientAddressEntity recipient;

    public List<GoodEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodEntity> goods) {
        this.goods = goods;
    }

    public double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public double getProxyprice() {
        return proxyprice;
    }

    public void setProxyprice(double proxyprice) {
        this.proxyprice = proxyprice;
    }

    public String getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(String modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public OrderEntity.Status getStatus() {
        return status;
    }

    public void setStatus(OrderEntity.Status status) {
        this.status = status;
    }

    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    private List<GoodEntity> goods;
    private double goodsprice;
    private double proxyprice;
    private String modifiedtime;
    private OrderEntity.Status status;
    private StoreEntity store;
    private AddressEntity address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public UserEntity getBuyer() {
        return buyer;
    }

    public void setBuyer(UserEntity buyer) {
        this.buyer = buyer;
    }

    public UserEntity getProxy() {
        return proxy;
    }

    public void setProxy(UserEntity proxy) {
        this.proxy = proxy;
    }

    public RecipientAddressEntity getRecipient() {
        return recipient;
    }

    public void setRecipient(RecipientAddressEntity recipient) {
        this.recipient = recipient;
    }
}