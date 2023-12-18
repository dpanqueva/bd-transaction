package com.invexdijin.bd.transaction.application;

import com.invexdijin.bd.transaction.domain.model.InitSearchEntity;

@FunctionalInterface
public interface IUseCaseSaveTriedSearchService {

    public InitSearchEntity saveTriedSearch(InitSearchEntity request);
}
