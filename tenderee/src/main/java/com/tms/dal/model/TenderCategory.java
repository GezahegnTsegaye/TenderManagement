package com.tms.dal.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "tender_category")
public class TenderCategory {

    @Id
    private Long id;
    private String name;
    private String description;

}
