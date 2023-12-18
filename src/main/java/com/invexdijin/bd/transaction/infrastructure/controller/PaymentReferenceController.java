package com.invexdijin.bd.transaction.infrastructure.controller;

import com.invexdijin.bd.transaction.infrastructure.model.in.payment.PaymentReferenceDto;
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


    @PostMapping("/create-payment")
    public ResponseEntity<Map<String, Object>> createPayment(@RequestBody PaymentReferenceDto paymentReference){
        Map<String,Object> response = new HashMap<>();
        response.put("message","Created reference payment");
        return ResponseEntity.created(URI.create("/api/v1/invexdijin/payment-payment")).body(response);

    }
}
