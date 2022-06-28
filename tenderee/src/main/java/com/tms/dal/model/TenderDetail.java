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
    private String paymentMod;
    private String coverContent;
    private String documentDescription;
    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

}
