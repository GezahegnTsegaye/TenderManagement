package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "winner")
public class Winner {

  @Id
  @GeneratedValue(generator = "winner_id_gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "winner_id_gen", sequenceName = "winner_id_seq", allocationSize = 1)
  private Long id;

  private Double winnerPrice;
  private String description;
}
