package com.example.demo.Controller;

import com.example.demo.Domain.Entity.RecipientAddressEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;
import com.example.demo.Service.RecipientAddressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/RecipientAddress")
@Api(value="RecipientAddress", description = "RecipientAddressController")
public class RecipientAddressController {
    @Autowired
    private RecipientAddressService recipientAddressService;

    @GetMapping("/{id}")
    public RecipientAddressEntity getById(@PathVariable long id){
        return recipientAddressService.getById(id);
    }

    @GetMapping("")
    public List<RecipientAddressEntity> get(){
        return recipientAddressService.getAll();
    }

    @PostMapping("")
    public RecipientAddressEntity create(@RequestBody RecipientAddressEntity recipientAddressEntity, @RequestParam(defaultValue = "true") boolean createAddress){
        return recipientAddressService.create(recipientAddressEntity, createAddress);
    }

    @PutMapping("/{id}")
    public RecipientAddressEntity modify(@PathVariable long id, @RequestBody RecipientAddressEntity recipientAddressEntity){
        return recipientAddressService.modify(id, recipientAddressEntity);
    }

    @PostMapping("/user/{userId}")
    public RecipientAddressEntity createByUserId(@PathVariable long userId, @PathVariable long recipientAddressId, @RequestBody RecipientAddressEntity recipientAddressEntity, @RequestParam(defaultValue = "true") boolean createAddress){
        return recipientAddressService.createByUserId(userId, recipientAddressEntity, createAddress);
    }

    @DeleteMapping("/user/{userId}/recipientAddress/{recipientAddressId}")
    public RmpReturnValue deleteByUserId(@PathVariable long userId, @PathVariable long recipientAddressId){
        return recipientAddressService.deleteByUserId(userId, recipientAddressId);
    }
}
