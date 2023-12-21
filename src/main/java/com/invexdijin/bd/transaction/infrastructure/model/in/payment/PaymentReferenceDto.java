package com.invexdijin.bd.transaction.infrastructure.model.in.payment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaymentReferenceDto {

    private String paymentName;

    private String paymentLastName;

    private String paymentEmail;

    private String paymentDocumentType;

    private String paymentDocumentNumber;

    private String paymentContact;

    private String paymentSignature;

    private String paymentStatus;

    private InitSearchPaymentRefDto initSearch;


}
