package com.tms.dal.model;


import jakarta.persistence.*;
import lombok.*;




@Setter@Getter @NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tender")
public class Tender {

    @Id
    @GeneratedValue(generator = "tender_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tender_id_gen", sequenceName = "tender_id_seq", allocationSize = 1)
    private Long id;
    private String tenderReferenceNumber;
    @ManyToOne
    @JoinColumn(name = "tender_type_id")
    private TenderType tenderType;
    @ManyToOne
    @JoinColumn(name = "tender_category_id")
    private TenderCategory tenderCategory;
    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;

    private Boolean reBidSubmission;
    private Boolean withdrawalBids;
    private Boolean offlineSubmission;
    private Boolean technicalEvaluation;
    private Boolean multiCurrency;



}
