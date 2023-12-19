package com.invexdijin.bd.transaction.infrastructure.controller;

import com.invexdijin.bd.transaction.application.IUseCasePaymentReferenceService;
import com.invexdijin.bd.transaction.domain.model.InitSearchEntity;
import com.invexdijin.bd.transaction.domain.model.PaymentEntity;
import com.invexdijin.bd.transaction.infrastructure.model.in.payment.PaymentReferenceDto;
import com.invexdijin.bd.transaction.infrastructure.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class PaymentReferenceController {

    @Autowired
    private IUseCasePaymentReferenceService paymentReferenceService;

    @Autowired
    private MapperUtil mapperUtil;

    @PostMapping("/create-payment")
    public ResponseEntity<Map<String, Object>> createPayment(@RequestBody PaymentReferenceDto paymentReference){
        Map<String,Object> response = new HashMap<>();
        PaymentEntity payment = mapperUtil.map(paymentReference, PaymentEntity.class);
        InitSearchEntity initSearchEntity  = InitSearchEntity.builder().id(paymentReference.getInitSearch().getId()).build();
        payment.setInitSearch(initSearchEntity);
        paymentReferenceService.createPayment(payment);
        response.put("message","Created reference payment");
        return ResponseEntity.created(URI.create("/api/v1/invexdijin/payment-payment")).body(response);

    }
}
