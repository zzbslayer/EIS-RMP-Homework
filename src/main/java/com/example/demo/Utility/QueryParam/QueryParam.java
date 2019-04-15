package com.example.demo.Utility.QueryParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public abstract class QueryParam {

    public enum QueryMode {ALL, NEARBY, USER}

    private  QueryMode mode;

    @Max(180)
    @Min(-180)
    private Double longitude;
    private Double latitude;

    QueryParam(){
        mode = QueryMode.ALL;
    }

    public QueryMode getMode() {
        return mode;
    }

    public void setMode(QueryMode mode) {
        this.mode = mode;
    }


    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public abstract boolean validate();
}
