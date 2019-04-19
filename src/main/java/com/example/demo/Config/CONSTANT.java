package com.example.demo.Config;

public interface CONSTANT {
    String RMP_SERVER = "http://47.102.152.51:8080/Entity/U478c3741ec44d/EIS/";
    String RMP_USER_API = RMP_SERVER + "User/";
    String RMP_STORE_API = RMP_SERVER + "Store/";
    String RMP_ORDER_API = RMP_SERVER + "Order/";
    String RMP_ADDRESS_API = RMP_SERVER + "Address/";
    String RMP_GOOD_API = RMP_SERVER + "Good/";
    String RMP_RECIPIENTADDRESS = RMP_SERVER + "Recipientaddress/";

    String BAIDU_GEOCODER_API = "http://api.map.baidu.com/geocoder/v2/";
    String AK = "lq1MAo2bZoPuReD0FyhzmzN2ISqGYHA2";

    static String buildGeocoderAPI(String address){
        StringBuilder sb = new StringBuilder();
        sb.append(BAIDU_GEOCODER_API);
        sb.append("?address=");
        sb.append(address);
        sb.append("&output=json&ak=");
        sb.append(AK);
        //sb.append("&callback=showLocation");
        return sb.toString();
    }

    String NULL_VALUE = "NULL";
    String ERROR_VALUE = "ERROR";

    String DEFAULT_AVATAR = "NULL";

    double MAX_LONGITUDE = 180;
    double MIN_LONGITUDE = -180;
    double MAX_LATITUDE = 90;
    double MIN_LATITUDE = -90;
}
