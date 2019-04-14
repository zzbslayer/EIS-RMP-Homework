package com.example.demo.Utility;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonHelper {
    public static <T> T jsonStringToObject(String json, Class<T> type){
        return JSON.toJavaObject(JSONObject.parseObject(json), type);
    }

    public static <T> List<T> jsonStringToList(String json, Class<T> type){
        return JSONObject.parseArray(json, type);
    }
}
