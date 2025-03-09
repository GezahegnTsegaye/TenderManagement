package com.egov.tendering.audit.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor@Setter@Getter
@Entity
@Table(name = "bid")
public class Bid {

  @Id
  @Column(name = "bidId")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid_seq_gen")
  @SequenceGenerator(name = "bid_seq_gen", sequenceName = "bid_seq", allocationSize = 1)
  private Long id;

  @Column(name = "price")
  private Double price;




}
