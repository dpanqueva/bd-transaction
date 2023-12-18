package com.invexdijin.bd.transaction.application;

import com.invexdijin.bd.transaction.domain.model.PaymentEntity;

@FunctionalInterface
public interface IUseCasePaymentReferenceService {

    void createPayment(PaymentEntity payment);
}
