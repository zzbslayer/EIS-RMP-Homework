package com.example.demo.Domain.Entity;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Domain.EntityInterface;
import org.springframework.core.annotation.Order;

import java.util.List;

public class OrderEntity implements EntityInterface {

    public static OrderEntity create(OrderProxy orderProxy){
        OrderEntity res = new OrderEntity();
        res.id = orderProxy.getId();
        res.address = orderProxy.getAddress();
        res.goumai = orderProxy.getBuyer();
        res.daigou = orderProxy.getProxy();
        res.goods = orderProxy.getGoods();
        res.goodsprice = orderProxy.getGoodsprice();
        res.proxyprice = orderProxy.getProxyprice();
        res.shijian = orderProxy.getModifiedtime();
        res.recipientaddress = orderProxy.getRecipient();
        res.orderstatus = orderProxy.getStatus();
        res.store = orderProxy.getStore();
        return res;
    }

    public RecipientAddressEntity getRecipientaddress() {
        return recipientaddress;
    }

    public void setRecipientaddress(RecipientAddressEntity recipientaddress) {
        this.recipientaddress = recipientaddress;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public enum Status {
        WAITING, BUYING, SENDING, TO_BE_CHECKED, EXPIRED, COMPLETED;
    }

    private long id;
    private UserEntity goumai;
    private UserEntity daigou;
    private RecipientAddressEntity recipientaddress;
    private List<GoodEntity> goods;
    private double goodsprice;
    private double proxyprice;
    private String shijian;
    private OrderEntity.Status orderstatus;
    private StoreEntity store;
    private AddressEntity address;

    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getGoumai() {
        return goumai;
    }

    public void setGoumai(UserEntity goumai) {
        this.goumai = goumai;
    }

    public UserEntity getDaigou() {
        return daigou;
    }

    public void setDaigou(UserEntity daigou) {
        this.daigou = daigou;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public Status getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Status orderstatus) {
        this.orderstatus = orderstatus;
    }

    @Override
    public JSONObject createRequestBody() {
        JSONObject json = new JSONObject();
        /*
        JSONObject goumai = new JSONObject();
        goumai.put("id", buyerId);
        JSONObject daigou = new JSONObject();
        daigou.put("id", proxyId);*/
        json.put("goumai", goumai);
        json.put("daigou", daigou);
        json.put("shijian", shijian);
        json.put("orderstatus", Status.WAITING);
        json.put("goodsprice", goodsprice);
        json.put("proxyprice", proxyprice);
        json.put("goods", goods);
        json.put("address", address);
        json.put("recipientaddress", recipientaddress);
        json.put("store", store);

        return json;
    }

    @Override
    public JSONObject modifyRequestBody() {
        JSONObject json = createRequestBody();
        json.put("orderstatus", orderstatus);
        json.put("id", id);
        return json;
    }
}
