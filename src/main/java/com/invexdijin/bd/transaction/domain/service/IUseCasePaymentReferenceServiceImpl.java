package com.invexdijin.bd.transaction.domain.service;

import com.invexdijin.bd.transaction.application.IUseCasePaymentReferenceService;
import com.invexdijin.bd.transaction.domain.model.PaymentEntity;
import com.invexdijin.bd.transaction.domain.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUseCasePaymentReferenceServiceImpl implements IUseCasePaymentReferenceService {

    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public void createPayment(PaymentEntity payment) {
        paymentRepository.save(payment);
    }
}
