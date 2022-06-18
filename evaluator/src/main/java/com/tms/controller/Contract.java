package com.tms.controller;

import javax.persistence.Id;

public class Contract {

    @Id
    private long id;
    private String contract_name;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String status;
    private String createdBy;
    private String createdDate;
    private String updatedBy;
    private String updatedDate;
    private String deletedBy;
    private String deletedDate;

}
