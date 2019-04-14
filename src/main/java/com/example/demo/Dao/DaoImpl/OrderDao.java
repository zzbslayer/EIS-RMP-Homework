package com.example.demo.Dao.DaoImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Config.CONSTANT;
import com.example.demo.Dao.DaoInterface;
import com.example.demo.Domain.Entity.OrderEntity;
import com.example.demo.Utility.HttpRequest;
import com.example.demo.Utility.JsonHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDao implements DaoInterface<Long, OrderEntity> {
    public OrderEntity getById(Long id){
        String url = CONSTANT.RMP_ORDER_API + String.valueOf(id);
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        if (data.equals(CONSTANT.NULL_VALUE))
            return null;
        return JsonHelper.jsonStringToObject(data, OrderEntity.class);
    }

    public OrderEntity create(OrderEntity orderEntity) {
        JSONObject jsonParam = orderEntity.createRequestBody();
        String url = CONSTANT.RMP_ORDER_API;
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_POST, jsonParam, url);
        return JsonHelper.jsonStringToObject(data, OrderEntity.class);
    }

    public OrderEntity modify(Long id, OrderEntity orderEntity) {
        JSONObject jsonParam = orderEntity.modifyRequestBody();
        String url= CONSTANT.RMP_ORDER_API + String.valueOf(id);
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_PUT, jsonParam, url);
        return JsonHelper.jsonStringToObject(data, OrderEntity.class);
    }

    public List<OrderEntity> getAll() {
        String url = CONSTANT.RMP_ORDER_API;
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        if (data.equals(CONSTANT.NULL_VALUE))
            return new ArrayList<>();

        /*
        Extract
            { "Order": [{...},{...}] }
        to
            [{...},{...}]
         */
        JSONArray json = JSONObject.parseObject(data).getJSONArray("Good");
        return JsonHelper.jsonStringToList(json.toString(), OrderEntity.class);
    }
}
