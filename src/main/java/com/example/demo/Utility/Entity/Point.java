package com.example.demo.Utility.Entity;

public class Point {
    private double lng;
    private double lat;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(lng);
        sb.append(", ");
        sb.append(lat);
        sb.append(')');
        return sb.toString();
    }
}
