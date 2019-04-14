package com.example.demo.Controller;

import com.example.demo.Domain.Entity.GoodEntity;
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
    public GoodEntity getGoodById(@PathVariable long id){
        return goodService.getGoodById(id);
    }

    @GetMapping("")
    public List<GoodEntity> getGood(){
        return goodService.getAll();
    }

    @PostMapping("")
    public GoodEntity createGood(@RequestBody GoodEntity goodEntity){
        return goodService.createGood(goodEntity);
    }

    @PutMapping("/{id}")
    public GoodEntity modifyGood(@PathVariable long id, @RequestBody GoodEntity goodEntity){
        return goodService.modifyGood(id, goodEntity);
    }
}
