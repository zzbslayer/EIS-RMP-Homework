package com.example.demo.Controller;

import com.example.demo.Domain.Entity.StoreEntity;
import com.example.demo.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/{id}")
    public StoreEntity getStoreById(@PathVariable long id){
        return storeService.getStoreById(id);
    }

    @GetMapping("")
    public List<StoreEntity> getStore(){
        return storeService.getAll();
    }

    @PostMapping("")
    public StoreEntity createStore(@RequestBody StoreEntity storeEntity){
        System.out.println(storeEntity);
        return storeService.createStore(storeEntity);
    }

    @PutMapping("/{id}")
    public StoreEntity modifyStore(@PathVariable long id, @RequestBody StoreEntity storeEntity){
        StoreEntity res = storeService.modifyStore(id, storeEntity);
        System.out.println(res);
        return res;
    }

    @GetMapping("/nearby")
    public List<StoreEntity> getNearbyStores(@RequestParam double longitude, @RequestParam double latitude){
        return storeService.getNearbyStores(longitude, latitude);
    }
}
