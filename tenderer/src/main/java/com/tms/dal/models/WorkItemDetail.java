package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "work_item_detail")
public class WorkItemDetail {

    @Id
//    @GeneratedValue(generator = "work_item_detail_id_gen", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name = "work_item_detail_id_gen", sequenceName = "work_item_detail_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemTitles;
    private String itemDescription;
    private String locationDetail;
    private String pinCode;
    private String preQualificationDetail;
    private Boolean preBidMeeting;
    private String preBidMeetingPlace;
    private String productCategory;
    private String preBidMeetingAddress;
    private String productSubCategory;
    private String contractType;
    private String tenderValue;
    private String tenderClass;
    @Column(name = "bid_validity_period", nullable = false)
    private String bidValidityPeriod;
    private String invitingOfficer;
    private String invitingOfficerAddress;
    private String deliveryPeriodDays;


}
