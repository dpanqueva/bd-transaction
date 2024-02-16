package com.invexdijin.bd.transaction.domain.service;

import com.invexdijin.bd.transaction.application.IUseCaseSaveTriedSearchService;
import com.invexdijin.bd.transaction.domain.model.InitSearchEntity;
import com.invexdijin.bd.transaction.domain.repository.IAttemptsDocumentRepository;
import com.invexdijin.bd.transaction.domain.repository.IInitSearchRepository;
import com.invexdijin.bd.transaction.infrastructure.exceptions.AttemptsLimitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class UseCaseSaveTriedSearchServiceServiceImpl implements IUseCaseSaveTriedSearchService {

    @Autowired
    private IInitSearchRepository initSearchRepository;

    @Autowired
    private IAttemptsDocumentRepository attemptsDocumentRepository;


    @Override
    public InitSearchEntity saveTriedSearch(InitSearchEntity request) {
        if (attemptsDocumentRepository.countByDocumentTypeAndDocumentNumberAndSearchDate(request.getDocumentType(),
                request.getDocumentNumber(), new Date()) >= 3) {
            throw new AttemptsLimitException("You have exceeded the limit of allowed searches.");
        }


        Date date = new Date();
        String strDate = String.valueOf(date.getTime());
        request.setId(strDate.concat("-").concat(UUID.randomUUID().toString()));
        request.setSearchDate(date);
        return initSearchRepository.save(request);


    }
}
