package com.invexdijin.bd.transaction.infrastructure.model.in.contact;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDto {

    private String contactName;

    private String contactEmail;

    private BigInteger contactNumber;

    private String contactMessage;
}
