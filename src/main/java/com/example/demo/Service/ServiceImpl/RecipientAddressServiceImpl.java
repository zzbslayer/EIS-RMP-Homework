package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.AddressDao;
import com.example.demo.Dao.DaoImpl.RecipientAddressDao;
import com.example.demo.Dao.DaoImpl.UserDao;
import com.example.demo.Domain.Entity.AddressEntity;
import com.example.demo.Domain.Entity.RecipientAddressEntity;
import com.example.demo.Domain.Entity.UserEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;
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
    @Autowired
    private AddressDao addressDao;

    @Override
    public RecipientAddressEntity getById(long id) {
        return recipientAddressDao.getById(id);
    }

    @Override
    public RecipientAddressEntity create(RecipientAddressEntity recipientAddressEntity, boolean createAddress) {
        if (createAddress){
            AddressEntity addressEntity = addressDao.create(recipientAddressEntity.getAddress());
            recipientAddressEntity.setAddress(addressEntity);
        }
        return recipientAddressDao.create(recipientAddressEntity);
    }

    @Override
    public RecipientAddressEntity modify(long id, RecipientAddressEntity recipientAddressEntity) {
        return recipientAddressDao.modify(id, recipientAddressEntity);
    }

    @Override
    public List<RecipientAddressEntity> getAll() {
        return recipientAddressDao.getAll();
    }

    @Override
    public RecipientAddressEntity createByUserId(long userid, RecipientAddressEntity recipientAddressEntity, boolean createAddress) {
        RecipientAddressEntity r = this.create(recipientAddressEntity, createAddress);
        UserEntity userEntity = userDao.getById(userid);
        List<RecipientAddressEntity> address = userEntity.getAddress();
        address.add(r);
        userDao.modify(userid, userEntity);
        return r;
    }

    @Override
    public RmpReturnValue delete(long addressid) {
        return recipientAddressDao.delete(addressid);
    }

    @Override
    public RmpReturnValue deleteByUserId(long userid, long addressid) {
        UserEntity userEntity = userDao.getById(userid);
        List<RecipientAddressEntity> addresses = userEntity.getAddress();
        int i = 0;
        for (RecipientAddressEntity r: addresses){
            if (r.getId() == addressid){
                break;
            }
            i++;
        }
        addresses.remove(i);
        userEntity.setAddress(addresses);
        userDao.modify(userid, userEntity);
        return recipientAddressDao.delete(addressid);
    }
}
