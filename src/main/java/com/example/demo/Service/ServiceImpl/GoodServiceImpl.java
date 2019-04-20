package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.GoodDao;
import com.example.demo.Dao.DaoImpl.StoreDao;
import com.example.demo.Domain.Entity.GoodEntity;
import com.example.demo.Domain.Entity.StoreEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;
import com.example.demo.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodDao goodDao;
    @Autowired
    private StoreDao storeDao;

    @Override
    public GoodEntity getById(long id) {
        return goodDao.getById(id);
    }

    @Override
    public GoodEntity create(GoodEntity goodEntity) {
        return goodDao.create(goodEntity);
    }

    @Override
    public GoodEntity modify(long id, GoodEntity goodEntity) {
        return goodDao.modify(id, goodEntity);
    }

    @Override
    public List<GoodEntity> getAll() {
        return goodDao.getAll();
    }

    @Override
    public GoodEntity createByStoreId(long storeId, GoodEntity goodEntity) {
        StoreEntity storeEntity = storeDao.getById(storeId);
        if (storeEntity == null)
            return null;
        GoodEntity g = goodDao.create(goodEntity);
        List<GoodEntity> goodEntities = storeEntity.getGoods();
        goodEntities.add(g);
        storeEntity.setGoods(goodEntities);
        storeDao.modify(storeId, storeEntity);
        return g;
    }

    @Override
    public RmpReturnValue deleteByStoreId(long storeId, long goodId) {
        StoreEntity storeEntity = storeDao.getById(storeId);
        List<GoodEntity> goodEntities = storeEntity.getGoods();
        if (storeEntity == null)
            return null;
        int i = 0;
        for (GoodEntity g: goodEntities){
            if (g.getId() == goodId){
                break;
            }
            i++;
        }
        goodEntities.remove(i);
        storeEntity.setGoods(goodEntities);
        storeDao.modify(storeId, storeEntity);
        return goodDao.delete(goodId);
    }
}
