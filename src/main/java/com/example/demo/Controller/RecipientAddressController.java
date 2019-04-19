package com.example.demo.Controller;

import com.example.demo.Domain.Entity.AddressEntity;
import com.example.demo.Domain.Entity.RecipientAddressEntity;
import com.example.demo.Service.AddressService;
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
    public RecipientAddressEntity getRecipientAddressById(@PathVariable long id){
        return recipientAddressService.getRecipientAddressById(id);
    }

    @GetMapping("")
    public List<RecipientAddressEntity> getRecipientAddress(){
        return recipientAddressService.getAll();
    }

    @PostMapping("")
    public RecipientAddressEntity createRecipientAddress(@RequestBody RecipientAddressEntity recipientAddressEntity){
        return recipientAddressService.createRecipientAddress(recipientAddressEntity);
    }

    @PutMapping("/{id}")
    public RecipientAddressEntity modifyRecipientAddress(@PathVariable long id, @RequestBody RecipientAddressEntity recipientAddressEntity){
        return recipientAddressService.modifyRecipientAddress(id, recipientAddressEntity);
    }

    @PostMapping("/user/{userId}/{recipientAddressId}")
    public RecipientAddressEntity createUserRecipientAddress(@PathVariable long userId, @PathVariable long recipientAddressId, @RequestBody RecipientAddressEntity recipientAddressEntity){
        return recipientAddressService.createRecipientAddressByUserId(userId, recipientAddressEntity);
    }
}
