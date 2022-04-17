package com.tms.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
public class TendererDetails {

    @Id
    private Long id;


}
