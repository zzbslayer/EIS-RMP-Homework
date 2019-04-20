package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.AddressDao;
import com.example.demo.Dao.DaoImpl.StoreDao;
import com.example.demo.Dao.DaoImpl.UserDao;
import com.example.demo.Domain.Entity.AddressEntity;
import com.example.demo.Domain.Entity.StoreEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;
import com.example.demo.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    AddressDao addressDao;
    @Autowired
    StoreDao storeDao;
    @Autowired
    UserDao userDao;

    @Override
    public AddressEntity getById(long id){
        return addressDao.getById(id);
    }

    @Override
    public AddressEntity create(AddressEntity addressEntity) {
        return addressDao.create(addressEntity);
    }

    @Override
    public AddressEntity modify(long id, AddressEntity addressEntity) {
        return addressDao.modify(id, addressEntity);
    }

    @Override
    public List<AddressEntity> getAll() {
        return addressDao.getAll();
    }

    @Override
    public AddressEntity createByStoreId(long storeid, AddressEntity addressEntity) {
        AddressEntity a = addressDao.create(addressEntity);
        StoreEntity storeEntity = storeDao.getById(storeid);
        storeEntity.setAddress(addressEntity);
        storeDao.modify(storeid, storeEntity);
        return a;
    }

    @Override
    public RmpReturnValue delete(long addressid) {
        return addressDao.delete(addressid);
    }
}
