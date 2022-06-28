package com.tms.dal.model;


import jakarta.persistence.*;
import lombok.*;


@Setter@Getter@ToString@AllArgsConstructor@NoArgsConstructor
@Entity
@Table
public class TenderType {

    @Id
    @GeneratedValue(generator = "tender_type_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tender_type_id_gen", sequenceName = "tender_type_id_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String description;

}
