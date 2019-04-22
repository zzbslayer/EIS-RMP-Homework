package com.example.demo.Service;


import com.example.demo.Domain.Entity.RecipientAddressEntity;
import com.example.demo.Domain.Utils.RmpReturnValue;

import java.util.List;

public interface RecipientAddressService {
    RecipientAddressEntity getById(long id);

    RecipientAddressEntity create(RecipientAddressEntity recipientAddressEntity, boolean createAddress);

    RecipientAddressEntity modify(long id, RecipientAddressEntity recipientAddressEntity);

    List<RecipientAddressEntity> getAll();

    RecipientAddressEntity createByUserId(long userid, RecipientAddressEntity recipientAddressEntity, boolean createAddress);

    RmpReturnValue delete(long addressid);

    RmpReturnValue deleteByUserId(long userid, long addressid);
}
