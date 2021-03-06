package com.example.demo.Dao.DaoImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Config.CONSTANT;
import com.example.demo.Dao.DaoInterface;
import com.example.demo.Domain.Entity.UserEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;
import com.example.demo.Utility.Network.HttpRequest;
import com.example.demo.Utility.Network.JsonHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements DaoInterface<Long, UserEntity> {
    public UserEntity getById(Long id){
        String url = CONSTANT.RMP_USER_API + String.valueOf(id);
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        if (data.equals(CONSTANT.NULL_VALUE))
            return null;
        return JsonHelper.jsonStringToObject(data, UserEntity.class);
    }

    public UserEntity create(UserEntity userEntity) {
        JSONObject jsonParam = userEntity.createRequestBody();
        String url= CONSTANT.RMP_USER_API;
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_POST, jsonParam, url);
        return JsonHelper.jsonStringToObject(data, UserEntity.class);
    }

    public UserEntity modify(Long id, UserEntity userEntity) {
        JSONObject jsonParam = userEntity.modifyRequestBody();
        System.out.println("[UserDao.modify][param]: ");
        System.out.println(jsonParam.toString());
        String url= CONSTANT.RMP_USER_API + String.valueOf(id);
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_PUT, jsonParam, url);
        System.out.println("[UserDao.modify][result]: ");
        System.out.println(data.toString());
        return JsonHelper.jsonStringToObject(data, UserEntity.class);
    }

    public List<UserEntity> getAll() {
        String url = CONSTANT.RMP_USER_API;
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        if (data.equals(CONSTANT.NULL_VALUE))
            return new ArrayList<>();

        /*
        Extract
            { "User": [{...},{...}] }
        to
            [{...},{...}]
         */
        JSONArray json = JSONObject.parseObject(data).getJSONArray("User");
        return JsonHelper.jsonStringToList(json.toString(), UserEntity.class);
    }

    public RmpReturnValue delete(Long id){
        String url = CONSTANT.RMP_USER_API + String.valueOf(id);
        String data = HttpRequest.request(HttpRequest.METHOD_DELETE, url);
        return JsonHelper.jsonStringToObject(data, RmpReturnValue.class);
    }
}
