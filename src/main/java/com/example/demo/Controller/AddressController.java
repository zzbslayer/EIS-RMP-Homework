package com.example.demo.Controller;

import com.example.demo.Domain.Entity.AddressEntity;
import com.example.demo.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public AddressEntity getAddressById(@PathVariable long id){
        return addressService.getAddressById(id);
    }

    @GetMapping("")
    public List<AddressEntity> getAddress(){
        return addressService.getAll();
    }

    @PostMapping("")
    public AddressEntity createAddress(@RequestBody AddressEntity addressEntity){
        return addressService.createAddress(addressEntity);
    }

    @PutMapping("/{id}")
    public AddressEntity modifyAddress(@PathVariable long id, @RequestBody AddressEntity addressEntity){
        return addressService.modifyAddress(id, addressEntity);
    }
}