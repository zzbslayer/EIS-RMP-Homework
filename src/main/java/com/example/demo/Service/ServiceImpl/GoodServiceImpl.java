package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.GoodDao;
import com.example.demo.Domain.Entity.GoodEntity;
import com.example.demo.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodDao goodDao;

    @Override
    public GoodEntity getGoodById(long id) {
        return goodDao.getById(id);
    }

    @Override
    public GoodEntity createGood(GoodEntity goodEntity) {
        return goodDao.create(goodEntity);
    }

    @Override
    public GoodEntity modifyGood(long id, GoodEntity goodEntity) {
        return goodDao.modify(id, goodEntity);
    }

    @Override
    public List<GoodEntity> getAll() {
        return goodDao.getAll();
    }
}
