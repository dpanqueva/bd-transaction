package com.invexdijin.bd.transaction.infrastructure.model.in.payment;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InitSearchPaymentRefDto {

    private String id;

    private String documentType;

    private String documentNumber;

    private String firstName;

    private String lastName;

    private String fullName;

    private String cellphone;

    private String searchType;

    private Date searchDate;

}
