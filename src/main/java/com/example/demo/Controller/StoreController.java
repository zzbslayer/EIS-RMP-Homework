package com.example.demo.Controller;

import com.example.demo.Domain.Entity.StoreEntity;
import com.example.demo.Service.StoreService;
import static com.example.demo.Utility.QueryParam.QueryParam.QueryMode;

import com.example.demo.Utility.QueryParam.QueryParam;
import com.example.demo.Utility.QueryParam.StoreQueryParam;
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
        return storeService.getStoreById(id);
    }

    /*todo*/
    @GetMapping("")
    public List<StoreEntity> getStore(@RequestBody StoreQueryParam param){
        if (param.validate()){
            QueryParam.QueryMode mode = param.getMode();
            if (mode == QueryMode.ALL)
                return storeService.getAll();
            else if (mode == QueryMode.NEARBY)
                return storeService.getNearbyStores(param.getLongitude(), param.getLatitude());
        }

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

}
