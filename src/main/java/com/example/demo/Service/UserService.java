package com.example.demo.Service;

import com.example.demo.Domain.Entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity getUserById(long id);

    UserEntity createUser(UserEntity userEntity);

    UserEntity modifyUser(long id, UserEntity userEntity);

    List<UserEntity> getAll();
}
