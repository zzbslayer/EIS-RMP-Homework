package com.example.demo.Controller;

import com.example.demo.Domain.Entity.AddressEntity;
import com.example.demo.Service.AddressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Address")
@Api(value="Address", description = "AddressController")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public AddressEntity getAddressById(@PathVariable long id){
        return addressService.getById(id);
    }

    @GetMapping("")
    public List<AddressEntity> getAddress(){
        return addressService.getAll();
    }

    @PostMapping("")
    public AddressEntity createAddress(@RequestBody AddressEntity addressEntity){
        return addressService.create(addressEntity);
    }

    @PutMapping("/{id}")
    public AddressEntity modifyAddress(@PathVariable long id, @RequestBody AddressEntity addressEntity){
        return addressService.modify(id, addressEntity);
    }
}
