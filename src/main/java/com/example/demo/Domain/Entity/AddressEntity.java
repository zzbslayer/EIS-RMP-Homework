package com.example.demo.Domain.Entity;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Domain.AbstractCoordinate;
import com.example.demo.Domain.EntityInterface;
import com.example.demo.Utility.Entity.Point;
import com.example.demo.Utility.Geography.Geocoder;
import com.example.demo.Utility.Geography.Geohash;

public class AddressEntity extends AbstractCoordinate implements EntityInterface {
    private long id;
    private String address;
    private String recipient;
    private String phone;

    public AddressEntity(){};

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public JSONObject createRequestBody() {
        JSONObject json = new JSONObject();
        json.put("address", address);
        json.put("recipient", recipient);
        json.put("phone", phone);
        Point point = Geocoder.geoEncode(address);
        json.put("latitude", point.getLat());
        json.put("longitude", point.getLng());
        json.put("geohash", Geohash.geohash(point.getLng(), point.getLat(), Geohash.DEFAULT_LENGTH));
        return json;
    }

    @Override
    public JSONObject modifyRequestBody() {
        JSONObject json = createRequestBody();
        json.put("id", id);
        return json;
    }
}
