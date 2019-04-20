package com.example.demo.Service;

import com.example.demo.Domain.Entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity getById(long id);

    UserEntity create(UserEntity userEntity);

    UserEntity modify(long id, UserEntity userEntity);

    List<UserEntity> getAll();
}
