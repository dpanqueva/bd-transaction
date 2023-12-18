package com.invexdijin.bd.transaction.domain.service;

import com.invexdijin.bd.transaction.application.IUseCaseSaveContactMeService;
import com.invexdijin.bd.transaction.domain.model.ContactEntity;
import com.invexdijin.bd.transaction.domain.repository.IContactMeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseCaseSaveContactMeServiceImpl implements IUseCaseSaveContactMeService {

    @Autowired
    private IContactMeRepository contactMeRepository;

    @Override
    public void saveContactMe(ContactEntity contact) {
        contactMeRepository.save(contact);
    }
}
