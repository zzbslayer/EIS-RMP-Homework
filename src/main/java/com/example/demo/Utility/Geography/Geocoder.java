package com.example.demo.Utility.Geography;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Config.CONSTANT;
import com.example.demo.Utility.Entity.Point;
import com.example.demo.Utility.Network.HttpRequest;
import com.example.demo.Utility.Network.JsonHelper;

public class Geocoder {
    public static Point geoEncode(String address){
        String data = HttpRequest.request(HttpRequest.METHOD_GET, CONSTANT.buildGeocoderAPI(address));
        System.out.print(data);
        JSONObject json = JSONObject.parseObject(data).getJSONObject("result").getJSONObject("location");
        return JsonHelper.jsonObjectToObject(json, Point.class);
    }

    public static void main(String[] args){
        System.out.print(geoEncode("上海市闵行区东川路800号"));
    }
}
