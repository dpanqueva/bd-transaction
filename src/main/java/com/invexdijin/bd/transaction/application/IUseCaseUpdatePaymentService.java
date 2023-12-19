package com.invexdijin.bd.transaction.application;

import com.invexdijin.bd.transaction.domain.model.PaymentEntity;

@FunctionalInterface
public interface IUseCaseUpdatePaymentService {

    PaymentEntity updatePayment(String signature, String status);
}
