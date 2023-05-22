package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_type")
public class AccountType {

  @Id
//  @GeneratedValue(generator = "account_type_id_gen", strategy = GenerationType.SEQUENCE)
//  @SequenceGenerator(name = "account_type_id_gen", sequenceName = "account_type_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "account_name")
  private String name;
  @Column(name = "account_description")
  private String description;

}
