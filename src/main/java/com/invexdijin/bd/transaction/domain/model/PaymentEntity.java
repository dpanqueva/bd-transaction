package com.invexdijin.bd.transaction.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PaymentEntity {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_name")
    private String paymentName;

    @Column(name = "payment_last_name")
    private String paymentLastName;

    @Column(name = "payment_email")
    private String paymentEmail;

    @Column(name = "payment_document_type")
    private String paymentDocumentType;

    @Column(name = "payment_document_number")
    private String paymentDocumentNumber;

    @Column(name = "payment_contact")
    private String paymentContact;

    @Column(name = "payment_signature")
    private String paymentSignature;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_init_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @OneToOne
    @JoinColumn(name = "init_search_id", referencedColumnName = "init_search_id")
    private InitSearchEntity initSearch;

}
