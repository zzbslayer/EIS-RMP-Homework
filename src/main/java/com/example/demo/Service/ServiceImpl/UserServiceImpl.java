package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.UserDao;
import com.example.demo.Domain.Entity.UserEntity;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public UserEntity getById(long id){
        return userDao.getById(id);
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        return userDao.create(userEntity);
    }

    @Override
    public UserEntity modify(long id, UserEntity userEntity) {
        return userDao.modify(id, userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return userDao.getAll();
    }

    @Override
    public UserEntity getByPhone(String phone) {
        List<UserEntity> users = userDao.getAll();
        List<UserEntity> user = users.stream()
                .filter((e) -> e.getPhone().equals(phone))
                .collect(Collectors.toList());
        return user.get(0);
    }

    @Override
    public UserEntity login(UserEntity userEntity) {
        return this.getByPhone(userEntity.getPhone());
    }
}
