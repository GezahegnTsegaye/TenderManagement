package com.egov.tendering.tender.dal.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;



@Getter
public enum TenderType {

    OPEN("Open Tender"),
    SELECTIVE("Selective Tender"),
    LIMITED("Limited Tender"),
    SINGLE("Single Source Tender");

    private final String name;

    TenderType(String name) {
        this.name = name;
    }

}
