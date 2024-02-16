package com.invexdijin.bd.transaction.domain.service.schema;

import com.invexdijin.bd.transaction.application.schema.IUseCaseCreateSchemaService;
import com.invexdijin.bd.transaction.domain.repository.AttemptsDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseCaseCreateSchemaServiceImpl implements IUseCaseCreateSchemaService {

    @Autowired
    private AttemptsDocumentRepository documentRepository;

    @Override
    public void createSchema() {
        documentRepository.createSchema();
    }
}
