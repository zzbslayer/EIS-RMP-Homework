package com.example.demo.Dao.DaoImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Config.CONSTANT;
import com.example.demo.Dao.DaoInterface;
import com.example.demo.Domain.Entity.AddressEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;
import com.example.demo.Utility.Network.HttpRequest;
import com.example.demo.Utility.Network.JsonHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressDao implements DaoInterface<Long, AddressEntity> {

    public AddressEntity getById(Long id){
        String url = CONSTANT.RMP_ADDRESS_API + String.valueOf(id);
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        if (data.equals(CONSTANT.NULL_VALUE))
            return null;
        return JsonHelper.jsonStringToObject(data, AddressEntity.class);
    }

    public AddressEntity create(AddressEntity addressEntity) {
        JSONObject jsonParam = addressEntity.createRequestBody();
        System.out.println("[AddressDao.create][param]: ");
        System.out.println(jsonParam.toString());
        String url = CONSTANT.RMP_ADDRESS_API;
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_POST, jsonParam, url);
        System.out.println("[Address.create][result]: ");
        System.out.println(data.toString());
        return JsonHelper.jsonStringToObject(data, AddressEntity.class);
    }

    public AddressEntity modify(Long id, AddressEntity addressEntity) {
        JSONObject jsonParam = addressEntity.modifyRequestBody();
        System.out.println(jsonParam.get("address"));
        String url= CONSTANT.RMP_ADDRESS_API + String.valueOf(id);
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_PUT, jsonParam, url);
        return JsonHelper.jsonStringToObject(data, AddressEntity.class);
    }

    public List<AddressEntity> getAll() {
        String url = CONSTANT.RMP_ADDRESS_API;
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        if (data.equals(CONSTANT.NULL_VALUE))
            return new ArrayList<>();

        /*
        Extract
            { "Address": [{...},{...}] }
        to
            [{...},{...}]
         */
        JSONArray json = JSONObject.parseObject(data).getJSONArray("Address");
        return JsonHelper.jsonStringToList(json.toString(), AddressEntity.class);
    }

    public RmpReturnValue delete(Long id){
        String url = CONSTANT.RMP_ADDRESS_API + String.valueOf(id);
        String data = HttpRequest.request(HttpRequest.METHOD_DELETE, url);
        return JsonHelper.jsonStringToObject(data, RmpReturnValue.class);
    }
}
