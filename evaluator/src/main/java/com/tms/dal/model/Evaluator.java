package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "evaluator")
public class Evaluator {
  @Id
  @Column(name = "evaluator_Id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluator_seq_gen")
  @SequenceGenerator(name = "evaluator_seq_gen", sequenceName = "evaluator_seq", allocationSize = 1)
  private Long id;


  @Column(name = "First_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "address")
  private String address;

}
