package com.example.demo.Dao.DaoImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Config.CONSTANT;
import com.example.demo.Dao.DaoInterface;
import com.example.demo.Domain.Entity.AddressEntity;
import com.example.demo.Domain.Entity.GoodEntity;
import com.example.demo.Utility.HttpRequest;
import com.example.demo.Utility.JsonHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodDao implements DaoInterface<Long, GoodEntity> {
    public GoodEntity getById(Long id){
        String url = CONSTANT.RMP_GOOD_API + String.valueOf(id);
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        if (data.equals(CONSTANT.NULL_VALUE))
            return null;
        return JsonHelper.jsonStringToObject(data, GoodEntity.class);
    }

    public GoodEntity create(GoodEntity goodEntity) {
        JSONObject jsonParam = goodEntity.createRequestBody();
        String url = CONSTANT.RMP_GOOD_API;
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_POST, jsonParam, url);
        return JsonHelper.jsonStringToObject(data, GoodEntity.class);
    }

    public GoodEntity modify(Long id, GoodEntity goodEntity) {
        JSONObject jsonParam = goodEntity.modifyRequestBody();
        String url= CONSTANT.RMP_GOOD_API + String.valueOf(id);
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_PUT, jsonParam, url);
        return JsonHelper.jsonStringToObject(data, GoodEntity.class);
    }

    public List<GoodEntity> getAll() {
        String url = CONSTANT.RMP_GOOD_API;
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        if (data.equals(CONSTANT.NULL_VALUE))
            return new ArrayList<>();

        /*
        Extract
            { "Good": [{...},{...}] }
        to
            [{...},{...}]
         */
        JSONArray json = JSONObject.parseObject(data).getJSONArray("Good");
        return JsonHelper.jsonStringToList(json.toString(), GoodEntity.class);
    }
}
