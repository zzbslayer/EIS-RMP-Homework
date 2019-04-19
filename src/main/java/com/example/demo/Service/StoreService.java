package com.example.demo.Service;

import com.example.demo.Domain.Entity.StoreEntity;

import java.util.List;

public interface StoreService {
    StoreEntity getStoreById(long id);
    StoreEntity createStore(StoreEntity storeEntity);
    StoreEntity modifyStore(long id, StoreEntity storeEntity);
    List<StoreEntity> getAll();

    List<StoreEntity> getNearbyStores(double longitude, double latitude);

}
