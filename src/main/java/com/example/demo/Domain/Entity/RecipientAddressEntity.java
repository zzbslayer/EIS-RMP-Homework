package com.example.demo.Domain.Entity;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Domain.EntityInterface;

public class RecipientAddressEntity implements EntityInterface{
    private long id;
    private AddressEntity address;
    private String contact;
    private String phone;

    @Override
    public JSONObject createRequestBody() {
        JSONObject json = new JSONObject();

        JSONObject address = new JSONObject();
        address.put("id", this.address.getId());

        json.put("address", address);
        json.put("contact", contact);
        json.put("phone", phone);
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
        return address.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
