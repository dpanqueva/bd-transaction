package com.invexdijin.bd.transaction.domain.repository;

import com.invexdijin.bd.transaction.domain.model.AttemptsDocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IAttemptsDocumentRepository extends JpaRepository<AttemptsDocumentEntity,Long> {
    long countByDocumentTypeAndDocumentNumberAndSearchDate(String documentType, String documentNumber, Date dateSearch);
}
