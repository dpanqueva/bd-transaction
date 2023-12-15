package com.invexdijin.bd.transaction.domain.repository;

import com.invexdijin.bd.transaction.domain.model.InitSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IInitSearchRepository extends JpaRepository<InitSearchEntity, String> {

    long countByDocumentTypeAndDocumentNumberAndSearchDate(String documentType, String documentNumber, Date dateSearch);

    InitSearchEntity findByReferenceLocatorAndDate(String referenceLocator, Date searchDate);
}
