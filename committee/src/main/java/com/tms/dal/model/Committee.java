package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "committee")
public class Committee {

  @Id
  @GeneratedValue(generator = "committee_id_gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "committee_id_gen", sequenceName = "committee_id_seq", allocationSize = 1)
  private Long id;
  private String firstName;
  private String lastName;
  private String employeePosition;
  private String address;

}
