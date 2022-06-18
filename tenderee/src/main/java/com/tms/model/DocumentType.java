package com.tms.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class DocumentType {

    @Id
    private Long id;
    private String name;
    private String description;

}
