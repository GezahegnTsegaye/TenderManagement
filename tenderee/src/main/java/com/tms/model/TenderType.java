package com.tms.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TenderType {

    @Id
    private Long id;

    private String name;
    private String description;

}
