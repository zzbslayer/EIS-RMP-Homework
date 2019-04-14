package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.UserDao;
import com.example.demo.Domain.Entity.UserEntity;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public UserEntity getUserById(long id){
        return userDao.getById(id);
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userDao.create(userEntity);
    }

    @Override
    public UserEntity modifyUser(long id, UserEntity userEntity) {
        return userDao.modify(id, userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return userDao.getAll();
    }
}
