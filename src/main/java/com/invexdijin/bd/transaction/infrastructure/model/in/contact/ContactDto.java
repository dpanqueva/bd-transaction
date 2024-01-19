package com.invexdijin.bd.transaction.infrastructure.model.in.contact;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDto {

    private String contactName;

    private String contactEmail;

    private String contactNumber;

    private String contactMessage;
}
