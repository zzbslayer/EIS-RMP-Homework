package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.RecipientAddressDao;
import com.example.demo.Dao.DaoImpl.UserDao;
import com.example.demo.Domain.Entity.RecipientAddressEntity;
import com.example.demo.Domain.Entity.UserEntity;
import com.example.demo.Service.RecipientAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipientAddressServiceImpl implements RecipientAddressService{
    @Autowired
    private RecipientAddressDao recipientAddressDao;
    @Autowired
    private UserDao userDao;

    @Override
    public RecipientAddressEntity getRecipientAddressById(long id) {
        return recipientAddressDao.getById(id);
    }

    @Override
    public RecipientAddressEntity createRecipientAddress(RecipientAddressEntity recipientAddressEntity) {
        return recipientAddressDao.create(recipientAddressEntity);
    }

    @Override
    public RecipientAddressEntity modifyRecipientAddress(long id, RecipientAddressEntity recipientAddressEntity) {
        return recipientAddressDao.modify(id, recipientAddressEntity);
    }

    @Override
    public List<RecipientAddressEntity> getAll() {
        return recipientAddressDao.getAll();
    }

    @Override
    public RecipientAddressEntity createRecipientAddressByUserId(long userid, RecipientAddressEntity recipientAddressEntity) {
        RecipientAddressEntity r = recipientAddressDao.create(recipientAddressEntity);
        UserEntity userEntity = userDao.getById(userid);
        List<RecipientAddressEntity> address = userEntity.getAddress();
        address.add(r);
        userDao.modify(userid, userEntity);
        return r;
    }
}
