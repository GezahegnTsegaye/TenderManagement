package com.tms.dal.model;


import jakarta.persistence.*;
import lombok.*;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "tender_detail")
public class TenderDetail {

    @Id
    @GeneratedValue(generator = "tender_detail_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tender_detail_id_gen", sequenceName = "tender_detail_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "payment_mod")
    private String paymentMod;
    @Column(name = "cover_content")
    private String coverContent;
    @Column(name = "document_description")
    private String documentDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tender_id")
    private Tender tender;

}
