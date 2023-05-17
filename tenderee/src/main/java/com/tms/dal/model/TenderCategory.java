package com.tms.dal.model;


import jakarta.persistence.*;
import lombok.*;


@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "tender_category")
public class TenderCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "category_description")
    private String description;

}
