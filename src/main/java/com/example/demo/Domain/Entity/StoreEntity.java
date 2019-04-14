package com.example.demo.Domain.Entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Domain.AbstractCoordinate;
import com.example.demo.Domain.EntityInterface;
import com.example.demo.Utility.Geohash;

import java.util.List;

public class StoreEntity extends AbstractCoordinate implements EntityInterface {
    private long id;
    private String storename;
    private String location;
    private String image;
    private String description;

    private List<GoodEntity> goods;


    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        sb.append("storename: " + storename);
        sb.append("\nlongitude: " + this.getLongitude());
        sb.append("\nlatitude: " + this.getLatitude());
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
        json.put("location", location);
        json.put("image", image);
        json.put("description", description);
        json.put("latitude", this.getLatitude());
        json.put("longitude", this.getLongitude());
        json.put("geohash", Geohash.geohash(this.getLongitude(), this.getLatitude(), Geohash.DEFAULT_LENGTH));
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
}
