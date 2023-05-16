package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "contract_type")
public class ContractType {

  @Id
  @Column(name = "contract_type_id")
//  @GeneratedValue(generator = "contract_type_id_gen", strategy = GenerationType.SEQUENCE)
//  @SequenceGenerator(name = "contract_type_id_gen", sequenceName = "contract_type_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy = "contractType")
  private List<ContractDetail> contractDetails;

}
