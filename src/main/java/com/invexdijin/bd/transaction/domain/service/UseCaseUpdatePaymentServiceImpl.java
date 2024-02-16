package com.invexdijin.bd.transaction.domain.service;

import com.invexdijin.bd.transaction.application.IUseCaseUpdatePaymentService;
import com.invexdijin.bd.transaction.domain.model.PaymentEntity;
import com.invexdijin.bd.transaction.domain.repository.IPaymentRepository;
import com.invexdijin.bd.transaction.infrastructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UseCaseUpdatePaymentServiceImpl implements IUseCaseUpdatePaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public PaymentEntity updatePayment(String initSearchId, String status) {

        PaymentEntity paymentUpdate = paymentRepository.findByInitSearchId(initSearchId);
        if (paymentUpdate == null) {
            throw new NotFoundException("Resource not founded signature ".concat(initSearchId));
        }
        paymentUpdate.setPaymentStatus(status);
        paymentUpdate.setPaymentDate(new Date());

        return paymentRepository.save(paymentUpdate);
    }
}
