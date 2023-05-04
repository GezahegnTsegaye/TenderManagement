package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(generator = "contact_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "contact")
    private long id;
    private String contractName;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String status;
    private String createdBy;
    private String createdDate;
    private String updatedBy;
    private String updatedDate;
    private String deletedBy;
    private String deletedDate;

}
