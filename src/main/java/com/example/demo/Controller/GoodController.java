package com.example.demo.Controller;

import com.example.demo.Domain.Entity.GoodEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;
import com.example.demo.Service.GoodService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Good")
@Api(value="Good", description = "GoodController")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @GetMapping("/{id}")
    public GoodEntity getById(@PathVariable long id){
        return goodService.getById(id);
    }

    @GetMapping("")
    public List<GoodEntity> get(){
        return goodService.getAll();
    }

    @PostMapping("")
    public GoodEntity create(@RequestBody GoodEntity goodEntity){
        return goodService.create(goodEntity);
    }

    @PutMapping("/{id}")
    public GoodEntity modify(@PathVariable long id, @RequestBody GoodEntity goodEntity){
        return goodService.modify(id, goodEntity);
    }

    @PostMapping("/store/{storeId}")
    public GoodEntity createByStoreId(@PathVariable long storeId,@RequestBody GoodEntity goodEntity){
        return goodService.createByStoreId(storeId, goodEntity);
    }

    @DeleteMapping("/store/{storeId}/{goodId}")
    public RmpReturnValue deleteByStoreId(@PathVariable long storeId, @PathVariable long goodId){
        return goodService.deleteByStoreId(storeId, goodId);
    }
}
