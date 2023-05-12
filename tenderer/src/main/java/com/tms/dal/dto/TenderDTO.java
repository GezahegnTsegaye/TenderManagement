package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class TenderDTO {

    private Long tenderId;
    private String tenderName;
    private String tenderDescription;
    private String tenderType;
    private String tenderStatus;
    private LocalDate tenderStartDate;
    private LocalDate tenderEndDate;
}
