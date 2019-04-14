package com.example.demo.Service;

import com.example.demo.Domain.Entity.StoreEntity;

import java.util.List;

public interface GeohashService {
    List<StoreEntity> nearestStore(double longitude, double latitude);

}
