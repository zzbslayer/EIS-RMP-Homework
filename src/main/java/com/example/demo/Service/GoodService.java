package com.example.demo.Service;

import com.example.demo.Domain.Entity.GoodEntity;

import java.util.List;

public interface GoodService {
    GoodEntity getGoodById(long id);

    GoodEntity createGood(GoodEntity goodEntity);

    GoodEntity modifyGood(long id, GoodEntity goodEntity);

    List<GoodEntity> getAll();
}
