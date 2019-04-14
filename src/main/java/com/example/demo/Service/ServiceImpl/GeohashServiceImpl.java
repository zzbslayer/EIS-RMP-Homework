package com.example.demo.Service.ServiceImpl;

import com.example.demo.Domain.Entity.StoreEntity;
import com.example.demo.Service.GeohashService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeohashServiceImpl implements GeohashService {

    public List<StoreEntity> nearestStore(double longitude, double latitude) {
        return null;
    }

}
