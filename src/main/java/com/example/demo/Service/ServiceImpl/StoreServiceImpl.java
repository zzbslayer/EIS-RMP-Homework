package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.StoreDao;
import com.example.demo.Domain.Entity.StoreEntity;
import com.example.demo.Service.StoreService;
import com.example.demo.Utility.Geohash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreDao storeDao;

    @Override
    public StoreEntity getStoreById(long id){
        return storeDao.getById(id);
    }

    @Override
    public StoreEntity createStore(StoreEntity storeEntity) {
        return storeDao.create(storeEntity);
    }

    @Override
    public StoreEntity modifyStore(long id, StoreEntity storeEntity) {
        return storeDao.modify(id, storeEntity);
    }

    @Override
    public List<StoreEntity> getAll() {
        return storeDao.getAll();
    }

    @Override
    public List<StoreEntity> getNearbyStores(double longitude, double latitude) {
        String base = Geohash.geohash(longitude, latitude, Geohash.DEFAULT_LENGTH);
        List<StoreEntity> stores = getAll();
        List<StoreEntity> res =
                stores
                        .stream()
                        .filter((e) ->
                                (Geohash.match(base, e.getGeohash(), Geohash.DEFAULT_MATCH_LENGTH))
                        )
                        .sorted((a, b) -> {
                            double a_distance = storeDistance(longitude, latitude, a);
                            double b_distance = storeDistance(longitude, latitude, b);
                            if (a_distance < b_distance)
                                return -1;
                            else
                                return 1;
                        })
                        .collect(Collectors.toList());
        return res;
    }

    private static double storeDistance(double x1, double y1, StoreEntity s){
        return distance(x1, y1, s.getLongitude(), s.getLatitude());
    }
    private static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow((x1- x2), 2) + Math.pow(y1-y2, 2));
    }
}
