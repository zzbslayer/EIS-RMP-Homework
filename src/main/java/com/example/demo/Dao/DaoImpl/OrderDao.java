package com.example.demo.Dao.DaoImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Config.CONSTANT;
import com.example.demo.Dao.DaoInterface;
import com.example.demo.Domain.Entity.OrderEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;
import com.example.demo.Utility.Network.HttpRequest;
import com.example.demo.Utility.Network.JsonHelper;
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
        System.out.println("[OrderDao.create][param]: ");
        System.out.println(jsonParam.toString());
        String url = CONSTANT.RMP_ORDER_API;
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_POST, jsonParam, url);
        System.out.println("[Order.create][result]: ");
        System.out.println(data.toString());
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
        JSONArray json = JSONObject.parseObject(data).getJSONArray("Order");
        if (json == null)
            return new ArrayList<>();
        return JsonHelper.jsonStringToList(json.toString(), OrderEntity.class);
    }

    public RmpReturnValue delete(Long id){
        String url = CONSTANT.RMP_ORDER_API + String.valueOf(id);
        String data = HttpRequest.request(HttpRequest.METHOD_DELETE, url);
        return JsonHelper.jsonStringToObject(data, RmpReturnValue.class);
    }
}
