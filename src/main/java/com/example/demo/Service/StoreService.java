package com.example.demo.Service;

import com.example.demo.Domain.Entity.StoreEntity;

import java.util.List;

public interface StoreService {
    StoreEntity getById(long id);
    StoreEntity create(StoreEntity storeEntity, boolean createAddress);
    StoreEntity modify(long id, StoreEntity storeEntity, boolean updateGood, boolean updateAddress);
    List<StoreEntity> getAll();

    List<StoreEntity> getNearby(double longitude, double latitude);

}
