package com.invexdijin.bd.transaction.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TriedSearchDto {

    @JsonProperty("referenceLocator")
    private String id;
    private String documentType;
    private String documentNumber;
    private String cellphone;
    private String searchType;
}
