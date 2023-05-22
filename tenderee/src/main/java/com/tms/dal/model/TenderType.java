package com.tms.dal.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tender_type")
public class TenderType {

  @Id
  @GeneratedValue(generator = "tender_type_id_gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "tender_type_id_gen", sequenceName = "tender_type_id_seq", allocationSize = 1)
  private Long id;
  @Column(name = "tender_name")
  private String name;

  private String description;
  @OneToMany(mappedBy = "tenderType")
  private Set<Tender> tenders;

}
