package com.example.demo.Service;

import com.example.demo.Domain.Entity.AddressEntity;

import java.util.List;

public interface AddressService {
    AddressEntity getAddressById(long id);

    AddressEntity createAddress(AddressEntity addressEntity);

    AddressEntity modifyAddress(long id, AddressEntity userEntity);

    List<AddressEntity> getAll();

    AddressEntity createAddressByStoreId(long storeid, AddressEntity addressEntity);
}
