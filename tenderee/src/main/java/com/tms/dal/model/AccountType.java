package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.*;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class AccountType {

    @Id
    @GeneratedValue(generator = "account_type_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "account_type_id_gen", sequenceName = "account_type_id_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String description;

}
