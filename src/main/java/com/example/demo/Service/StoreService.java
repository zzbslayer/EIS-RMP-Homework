package com.example.demo.Service;

import com.example.demo.Domain.Entity.StoreEntity;

import java.util.List;

public interface StoreService {
    StoreEntity getById(long id);
    StoreEntity create(StoreEntity storeEntity);
    StoreEntity modify(long id, StoreEntity storeEntity);
    List<StoreEntity> getAll();

    List<StoreEntity> getNearby(double longitude, double latitude);

}
