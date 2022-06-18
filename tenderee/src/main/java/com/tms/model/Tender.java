package com.tms.model;


import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Tender {

    @Id
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
