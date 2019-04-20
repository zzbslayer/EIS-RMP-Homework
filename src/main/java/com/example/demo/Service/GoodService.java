package com.example.demo.Service;

import com.example.demo.Domain.Entity.GoodEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;

import java.util.List;

public interface GoodService {
    GoodEntity getById(long id);

    GoodEntity create(GoodEntity goodEntity);

    GoodEntity modify(long id, GoodEntity goodEntity);

    List<GoodEntity> getAll();

    GoodEntity createByStoreId(long storeId, GoodEntity goodEntity);

    RmpReturnValue deleteByStoreId(long storeId, long goodId);
}
