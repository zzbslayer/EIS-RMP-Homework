package com.example.demo.Controller;

import com.example.demo.Domain.Entity.UserEntity;
import com.example.demo.Service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/User")
@Api(value="User", description = "UserController")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable long id){
        return userService.getById(id);
    }

    @GetMapping("")
    public List<UserEntity> getUser(){
        return userService.getAll();
    }

    @PostMapping("")
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        return userService.create(userEntity);
    }

    @PutMapping("/{id}")
    public UserEntity modifyUser(@PathVariable long id, @RequestBody UserEntity userEntity){
        return userService.modify(id, userEntity);
    }

    @GetMapping("/phone/{phone}")
    public UserEntity getByPhone(@PathVariable String phone){
        return userService.getByPhone(phone);
    }

    @PostMapping("/login")
    public UserEntity login(@RequestBody UserEntity userEntity){
        return userService.login(userEntity);
    }
}
