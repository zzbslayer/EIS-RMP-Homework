package com.example.demo.Domain.Entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Domain.EntityInterface;
import com.example.demo.Utility.Entity.Point;
import com.example.demo.Utility.Geography.Geocoder;

import java.util.List;

public class StoreEntity implements EntityInterface {
    private long id;
    private String storename;
    private String image;
    private String description;
    private AddressEntity address;

    private List<GoodEntity> goods;


    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(storename);
        sb.append("\t");
        sb.append(address.toString());
        return sb.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public JSONObject createRequestBody() {
        JSONObject json = new JSONObject();
        json.put("storename", storename);
        json.put("image", image);
        json.put("description", description);
        Point point = Geocoder.geoEncode(address.getAddress());

        JSONObject address = new JSONObject();
        address.put("id", this.address.getId());

        json.put("address", address);
        json.put("goods", new JSONArray());
        return json;
    }

    @Override
    public JSONObject modifyRequestBody(){
        JSONObject json = createRequestBody();
        json.put("goods", goods);
        json.put("id", id);
        return json;
    }

    public List<GoodEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodEntity> goods) {
        this.goods = goods;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
