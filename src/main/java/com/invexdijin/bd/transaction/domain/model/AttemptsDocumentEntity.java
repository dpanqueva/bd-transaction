package com.invexdijin.bd.transaction.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "attempts_document")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQueries({
        @NamedQuery(name = "AttemptsDocumentEntity.countByDocumentTypeAndDocumentNumberAndSearchDate",
                query = "SELECT COUNT(a) FROM AttemptsDocumentEntity a WHERE a.documentType = :documentType AND a.documentNumber = :documentNumber AND a.searchDate = :dateSearch ")
})
public class AttemptsDocumentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attempt_id")
    private Long attemptId;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_number")
    private String documentNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "search_date")
    private Date searchDate;

}
