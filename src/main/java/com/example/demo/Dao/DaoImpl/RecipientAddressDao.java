package com.example.demo.Dao.DaoImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Config.CONSTANT;
import com.example.demo.Dao.DaoInterface;
import com.example.demo.Domain.Entity.RecipientAddressEntity;
import com.example.demo.Utility.Network.HttpRequest;
import com.example.demo.Utility.Network.JsonHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipientAddressDao implements DaoInterface<Long, RecipientAddressEntity> {
    public RecipientAddressEntity getById(Long id){
        String url = CONSTANT.RMP_RECIPIENTADDRESS + String.valueOf(id);
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        if (data.equals(CONSTANT.NULL_VALUE))
            return null;
        return JsonHelper.jsonStringToObject(data, RecipientAddressEntity.class);
    }

    public RecipientAddressEntity create(RecipientAddressEntity recipientAddressEntity) {
        JSONObject jsonParam = recipientAddressEntity.createRequestBody();
        String url = CONSTANT.RMP_RECIPIENTADDRESS;
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_POST, jsonParam, url);
        return JsonHelper.jsonStringToObject(data, RecipientAddressEntity.class);
    }

    public RecipientAddressEntity modify(Long id, RecipientAddressEntity recipientAddressEntity) {
        JSONObject jsonParam = recipientAddressEntity.modifyRequestBody();
        String url= CONSTANT.RMP_RECIPIENTADDRESS + String.valueOf(id);
        String data = HttpRequest.requestWithBody(HttpRequest.METHOD_PUT, jsonParam, url);
        return JsonHelper.jsonStringToObject(data, RecipientAddressEntity.class);
    }

    public List<RecipientAddressEntity> getAll() {
        String url = CONSTANT.RMP_RECIPIENTADDRESS;
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        if (data.equals(CONSTANT.NULL_VALUE))
            return new ArrayList<>();

        /*
        Extract
            { "Order": [{...},{...}] }
        to
            [{...},{...}]
         */
        JSONArray json = JSONObject.parseObject(data).getJSONArray("Recipientaddress");
        return JsonHelper.jsonStringToList(json.toString(), RecipientAddressEntity.class);
    }
}
