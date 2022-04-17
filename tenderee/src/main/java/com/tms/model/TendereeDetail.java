package com.tms.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;

@Data
@Builder
public class TendereeDetail {

    @Id
    private Long id;
    private String firstName;
    private String lastName;

}
