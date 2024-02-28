package com.invexdijin.bd.transaction.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "init_search")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "InitSearchEntity.countByDocumentTypeAndDocumentNumberAndSearchDate",
                query = "SELECT COUNT(s) FROM InitSearchEntity s WHERE s.documentType = :documentType AND s.documentNumber = :documentNumber AND s.searchDate = :dateSearch "),
        @NamedQuery(name = "InitSearchEntity.findByReferenceLocatorAndDate",
                query = "SELECT s FROM InitSearchEntity s WHERE s.id = :referenceLocator AND s.searchDate = :searchDate ")
})
@Builder
public class InitSearchEntity {
    @Id
    @Column(name = "init_search_id")
    private String id;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "contact_number")
    private String cellphone;

    @Column(name = "search_type")
    private String searchType;

    @Temporal(TemporalType.DATE)
    @Column(name = "search_date")
    private Date searchDate;

    @OneToOne(mappedBy = "initSearch", fetch = FetchType.LAZY)
    private PaymentEntity payment;

    @Column(name = "terms_conditions")
    private boolean termsConditions;


}
