package com.invexdijin.bd.transaction.infrastructure.controller;

import com.invexdijin.bd.transaction.application.IUseCaseUpdatePaymentService;
import com.invexdijin.bd.transaction.domain.model.PaymentEntity;
import com.invexdijin.bd.transaction.infrastructure.model.in.confirm.PaymentDto;
import com.invexdijin.bd.transaction.infrastructure.model.in.payment.PaymentReferenceDto;
import com.invexdijin.bd.transaction.infrastructure.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class UpdateStatusPaymentController {

    @Autowired
    private MapperUtil mapperUtil;

    @Autowired
    private IUseCaseUpdatePaymentService updatePaymentService;

    @PutMapping("update-payment")
    public ResponseEntity<Map<String, Object>> updatePayment(@RequestParam("signature") String signature,
                                                             @RequestParam("status") String status){
        Map<String, Object> response = new HashMap<>();
        PaymentEntity paymentUpdated = updatePaymentService.updatePayment(signature, status);
        PaymentReferenceDto paymentUpdatedDto = mapperUtil.map(paymentUpdated, PaymentReferenceDto.class);
        paymentUpdatedDto.setInitSearchId(paymentUpdated.getInitSearch().getId());
        response.put("payment", paymentUpdatedDto);
        return ResponseEntity.created(URI.create("/api/v1/invexdijin")).body(response);

    }
}
