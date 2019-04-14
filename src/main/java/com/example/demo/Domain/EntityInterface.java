package com.example.demo.Domain;

import com.alibaba.fastjson.JSONObject;

public interface EntityInterface {
    JSONObject createRequestBody();

    JSONObject modifyRequestBody();
}
