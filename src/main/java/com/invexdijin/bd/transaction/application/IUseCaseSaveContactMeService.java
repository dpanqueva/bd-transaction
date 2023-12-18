package com.invexdijin.bd.transaction.application;

import com.invexdijin.bd.transaction.domain.model.ContactEntity;

@FunctionalInterface
public interface IUseCaseSaveContactMeService {

    public void saveContactMe(ContactEntity contact);
}
