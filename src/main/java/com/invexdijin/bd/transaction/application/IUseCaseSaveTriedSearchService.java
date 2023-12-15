package com.invexdijin.bd.transaction.application;

import com.invexdijin.bd.transaction.domain.model.InitSearchEntity;
import com.invexdijin.bd.transaction.infrastructure.model.TriedSearchDto;

@FunctionalInterface
public interface IUseCaseSaveTriedSearchService {

    public InitSearchEntity saveTriedSearch(InitSearchEntity request);
}
