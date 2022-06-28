package com.tms.dal.model;


import jakarta.persistence.*;
import lombok.*;


@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "document_type")
public class DocumentType {

    @Id
    @GeneratedValue(generator = "document_type_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "document_type_id_gen", sequenceName = "document_type_id_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String description;

}
