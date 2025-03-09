package com.egov.tendering.audit.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "allocation_type")
public class AllocationType {

  @Id
  @GeneratedValue(generator = "allocation_type_id_gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "allocation_type_id_gen", sequenceName = "allocation_type_id_seq", allocationSize = 1)
  private Long id;
  private String type;

}
