package com.example.demo.Service;


import com.example.demo.Domain.Entity.RecipientAddressEntity;

import java.util.List;

public interface RecipientAddressService {
    RecipientAddressEntity getRecipientAddressById(long id);

    RecipientAddressEntity createRecipientAddress(RecipientAddressEntity recipientAddressEntity);

    RecipientAddressEntity modifyRecipientAddress(long id, RecipientAddressEntity recipientAddressEntity);

    List<RecipientAddressEntity> getAll();

    RecipientAddressEntity createRecipientAddressByUserId(long userid, RecipientAddressEntity recipientAddressEntity);
}
