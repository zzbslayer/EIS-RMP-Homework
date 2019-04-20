package com.example.demo.Service;

import com.example.demo.Domain.Entity.AddressEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;

import java.util.List;

public interface AddressService {
    AddressEntity getById(long id);

    AddressEntity create(AddressEntity addressEntity);

    AddressEntity modify(long id, AddressEntity userEntity);

    List<AddressEntity> getAll();

    AddressEntity createByStoreId(long storeid, AddressEntity addressEntity);

    RmpReturnValue delete(long addressid);


}
