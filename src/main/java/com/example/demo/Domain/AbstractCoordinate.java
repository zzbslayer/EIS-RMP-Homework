package com.example.demo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public abstract class AbstractCoordinate {
    @Max(180)
    @Min(-180)
    //@JsonIgnore
    private double longitude;

    @Max(90)
    @Min(-90)
    //@JsonIgnore
    private double latitude;

    //@JsonIgnore
    private String geohash;


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }
}
