package com.invexdijin.bd.transaction.domain.service;

import com.invexdijin.bd.transaction.application.IUseCaseConfirmSearchPayService;
import com.invexdijin.bd.transaction.domain.model.InitSearchEntity;
import com.invexdijin.bd.transaction.domain.repository.IInitSearchRepository;
import com.invexdijin.bd.transaction.infrastructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UseCaseConfirmSearchPayServiceImpl implements IUseCaseConfirmSearchPayService {

    @Autowired
    private IInitSearchRepository searchRepository;


    @Override
    public InitSearchEntity findByReferenceLocatorAndDate(String referenceLocator) {
        Date searchDate = new Date();
        InitSearchEntity initSearch = searchRepository.findByReferenceLocatorAndDate(referenceLocator, searchDate);
        if(initSearch == null){
            throw new NotFoundException("Not found referenceLocator".concat(" ").concat(referenceLocator));
        }
        return initSearch;
    }
}
