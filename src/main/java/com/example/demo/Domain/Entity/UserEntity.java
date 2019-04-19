package com.example.demo.Domain.Entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Config.CONSTANT;
import com.example.demo.Domain.EntityInterface;

import java.util.List;

public class UserEntity implements EntityInterface {
    private long id;
    private String username;
    private String phone;
    private String password;
    private String avatar;
    private List<RecipientAddressEntity> address;

    public UserEntity() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<RecipientAddressEntity> getAddress() {
        return address;
    }

    public void setAddress(List<RecipientAddressEntity> address) {
        this.address = address;
    }

    @Override
    public JSONObject createRequestBody(){
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("phone", phone);
        json.put("password", password);
        json.put("avatar", CONSTANT.DEFAULT_AVATAR);
        json.put("address", new JSONArray());
        return json;
    }

    @Override
    public JSONObject modifyRequestBody() {
        JSONObject json = createRequestBody();
        json.put("avatar", avatar);
        json.put("address", address);
        json.put("id", id);
        return json;
    }

    @Override
    public String toString(){
        return "User:"+ username;
    }
}
