package com.example.demo.Dao.DaoImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Config.CONSTANT;
import com.example.demo.Dao.DaoInterface;
import com.example.demo.Domain.Entity.StoreEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;
import com.example.demo.Utility.Network.HttpRequest;
import com.example.demo.Utility.Network.JsonHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreDao implements DaoInterface<Long, StoreEntity> {
    public StoreEntity getById(Long id){
        String url = CONSTANT.RMP_STORE_API + String.valueOf(id);
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        System.out.println("[StoreDao.getById]: " + data);
        if (data.equals(CONSTANT.NULL_VALUE))
            return null;
        return JsonHelper.jsonStringToObject(data, StoreEntity.class);
    }

    public StoreEntity create(StoreEntity storeEntity) {
        JSONObject jsonParam = storeEntity.createRequestBody();
        System.out.println("[StoreDao.create][param]: ");
        System.out.println(jsonParam.toString());
        String url= CONSTANT.RMP_STORE_API;
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_POST, jsonParam, url);
        System.out.println("[StoreDao.create][result]: ");
        System.out.println(data);
        return JsonHelper.jsonStringToObject(data, StoreEntity.class);
    }

    public StoreEntity modify(Long id, StoreEntity storeEntity) {
        JSONObject jsonParam = storeEntity.modifyRequestBody();
        System.out.println("[StoreDao.modify][param]: ");
        System.out.println(jsonParam.toString());
        String url= CONSTANT.RMP_STORE_API + String.valueOf(id);
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_PUT, jsonParam, url);
        System.out.println("[StoreDao.modify][result]: ");
        System.out.println(jsonParam.toString());
        return JsonHelper.jsonStringToObject(data, StoreEntity.class);
    }

    public List<StoreEntity> getAll() {
        String url = CONSTANT.RMP_STORE_API;
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        if (data.equals(CONSTANT.NULL_VALUE))
            return new ArrayList<>();

        /*
        Extract
            { "Store": [{...},{...}] }
        to
            [{...},{...}]
         */
        JSONArray json = JSONObject.parseObject(data).getJSONArray("Store");
        return JsonHelper.jsonStringToList(json.toString(), StoreEntity.class);
    }

    public RmpReturnValue delete(Long id){
        String url = CONSTANT.RMP_STORE_API + String.valueOf(id);
        String data = HttpRequest.request(HttpRequest.METHOD_DELETE, url);
        return JsonHelper.jsonStringToObject(data, RmpReturnValue.class);
    }
}
