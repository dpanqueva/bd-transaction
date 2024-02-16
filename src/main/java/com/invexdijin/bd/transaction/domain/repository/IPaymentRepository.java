package com.invexdijin.bd.transaction.domain.repository;

import com.invexdijin.bd.transaction.domain.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<PaymentEntity, Long> {

    @Query("SELECT p FROM PaymentEntity p WHERE p.initSearch.id =:initSearchId")
    PaymentEntity findByInitSearchId(String initSearchId);


}
