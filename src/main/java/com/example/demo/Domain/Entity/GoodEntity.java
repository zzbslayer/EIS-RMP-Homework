package com.example.demo.Domain.Entity;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Domain.EntityInterface;

public class GoodEntity implements EntityInterface {
    private long id;
    private String goodname;
    private double price;
    private String image;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
    public JSONObject createRequestBody() {
        JSONObject json = new JSONObject();
        json.put("goodname", goodname);
        json.put("price", price);
        json.put("image", image);
        json.put("description", description);
        return json;
    }

    @Override
    public JSONObject modifyRequestBody() {
        JSONObject json = createRequestBody();
        json.put("id", id);
        return json;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"id\":");
        sb.append(id);
        sb.append(", \"goodname\":");
        sb.append(goodname);
        sb.append("}");
        return sb.toString();
    }
}
