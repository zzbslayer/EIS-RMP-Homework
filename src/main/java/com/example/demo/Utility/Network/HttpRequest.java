package com.example.demo.Utility.Network;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Config.CONSTANT;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    public static String METHOD_GET = "GET";
    public static String METHOD_POST = "POST";
    public static String METHOD_PUT = "PUT";
    public static String METHOD_DELETE = "DELETE";

    private static String getResponse (HttpURLConnection conn) throws IOException{
        StringBuffer sb = new StringBuffer();
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            InputStream in1 = conn.getInputStream();
            try {
                String readLine;
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(in1,"UTF-8"));
                while((readLine = responseReader.readLine()) != null){
                    sb.append(readLine).append("\n");
                }
                responseReader.close();
            } catch (Exception e1) {
                e1.printStackTrace();
                return CONSTANT.ERROR_VALUE;
            }
        }
        else if (responseCode == HttpURLConnection.HTTP_ACCEPTED){
            return CONSTANT.NULL_VALUE;
        }
        else {
            System.out.println("[HttpRequest.getResponse][error]:"+conn.getResponseMessage());
            return CONSTANT.ERROR_VALUE;
        }
        return sb.toString();
    }

    public static String request(String method, String urls) {
        try {
            URL url = new URL(urls);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(method);
            conn.connect();
            return getResponse(conn);
        }
        catch (Exception e) {
            return CONSTANT.NULL_VALUE;
        }
    }
    public static String requestWithBody(String method, JSONObject jsonParam, String urls) {

        try {
            URL url = new URL(urls);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(method);
            byte[] data = (jsonParam.toString()).getBytes();
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            conn.setRequestProperty("Content-Type", "application/json");
            conn.connect();
            OutputStream out = new DataOutputStream(conn.getOutputStream()) ;
            out.write((jsonParam.toString()).getBytes());
            out.flush();
            out.close();
            return getResponse(conn);
        }
        catch (Exception e) {
            return CONSTANT.ERROR_VALUE;
        }
    }
    public static void main(String[] args) {
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("username", "test_user");
        jsonParam.put("phone", "18080808080");
        jsonParam.put("password", "qwerty");
        jsonParam.put("avatar", "null");
        jsonParam.put("address", new JSONArray());
        String url= CONSTANT.RMP_USER_API;
        String data = HttpRequest.requestWithBody(METHOD_POST, jsonParam, url);
        System.out.println(data);

        //StoreEntity store = JsonHelper.jsonStringToObject(data,StoreEntity.class);
        //System.out.println(store.toString());
    }
}
