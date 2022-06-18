package com.tms.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class WorkItemDetails {

    @Id
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
    private LocalDate BidValidityDays;
    private String invitingOfficer;
    private String invitingOfficerAddress;
    private String deliveryPeriodDays;


}
