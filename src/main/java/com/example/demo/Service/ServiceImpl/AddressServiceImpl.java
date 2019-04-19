package com.example.demo.Service.ServiceImpl;

import com.example.demo.Dao.DaoImpl.AddressDao;
import com.example.demo.Dao.DaoImpl.StoreDao;
import com.example.demo.Domain.Entity.AddressEntity;
import com.example.demo.Domain.Entity.StoreEntity;
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

    @Override
    public AddressEntity getAddressById(long id){
        return addressDao.getById(id);
    }

    @Override
    public AddressEntity createAddress(AddressEntity addressEntity) {
        return addressDao.create(addressEntity);
    }

    @Override
    public AddressEntity modifyAddress(long id, AddressEntity addressEntity) {
        return addressDao.modify(id, addressEntity);
    }

    @Override
    public List<AddressEntity> getAll() {
        return addressDao.getAll();
    }

    @Override
    public AddressEntity createAddressByStoreId(long storeid, AddressEntity addressEntity) {
        AddressEntity a = addressDao.create(addressEntity);
        StoreEntity storeEntity = storeDao.getById(storeid);
        storeEntity.setAddress(addressEntity);
        storeDao.modify(storeid, storeEntity);
        return a;
    }
}
