package com.example.demo.Domain.Entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Domain.EntityInterface;

import java.util.List;

public class OrderEntity implements EntityInterface {

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
    private UserEntity buyer;
    private UserEntity proxy;
    private RecipientAddressEntity recipientaddress;
    private List<GoodEntity> goods;
    private double goodsprice;
    private double proxyprice;
    private String modifiedtime;
    private OrderEntity.Status status;
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

    public String getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(String modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public JSONObject createRequestBody() {
        JSONObject json = new JSONObject();
        /*
        JSONObject buyer = new JSONObject();
        buyer.put("id", buyerId);
        JSONObject proxy = new JSONObject();
        proxy.put("id", proxyId);*/
        json.put("buyer", buyer);
        json.put("proxy", proxy);
        json.put("modifiedtime", modifiedtime);
        json.put("status", Status.WAITING);
        json.put("goodsprice", goodsprice);
        json.put("proxyprice", proxyprice);
        json.put("goods", goods);
        json.put("recipientaddress", recipientaddress);
        json.put("store", store);

        return json;
    }

    @Override
    public JSONObject modifyRequestBody() {
        JSONObject json = createRequestBody();
        json.put("status", status);
        json.put("id", id);
        return json;
    }
}
