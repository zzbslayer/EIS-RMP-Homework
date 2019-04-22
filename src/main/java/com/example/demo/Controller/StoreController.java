package com.example.demo.Controller;

import com.example.demo.Domain.Entity.StoreEntity;
import com.example.demo.Service.StoreService;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Store")
@Api(value="Store", description = "StoreController")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/{id}")
    public StoreEntity getStoreById(@PathVariable long id){
        return storeService.getById(id);
    }

    /*todo*/
    @GetMapping("")
    public List<StoreEntity> getStore(@RequestParam(required = false) String mode, @RequestParam(required = false) Double latitude, @RequestParam(required = false) Double longitude){

        if (mode == null || mode.equals("ALL"))
            return storeService.getAll();

        else if (mode.equals("NEARBY")) {
            //assert(latitude != null && longitude != null);
            return storeService.getNearby(longitude, latitude);
        }

        return storeService.getAll();
    }

    @PostMapping("")
    public StoreEntity createStore(@RequestBody StoreEntity storeEntity, @RequestParam(defaultValue = "true")boolean createAddress){
        System.out.println(storeEntity);
        return storeService.create(storeEntity, createAddress);
    }

    @PutMapping("/{id}")
    public StoreEntity modifyStore(@PathVariable long id, @RequestBody StoreEntity storeEntity, @RequestParam(defaultValue = "false") boolean updateGood, @RequestParam(defaultValue = "false") boolean updateAddress){
        StoreEntity res = storeService.modify(id, storeEntity, updateGood, updateAddress);
        System.out.println(res);
        return res;
    }

}
