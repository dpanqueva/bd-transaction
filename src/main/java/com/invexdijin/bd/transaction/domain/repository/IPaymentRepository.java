package com.invexdijin.bd.transaction.domain.repository;

import com.invexdijin.bd.transaction.domain.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<PaymentEntity, Long> {

    PaymentEntity findByPaymentSignature(String signature);
}
