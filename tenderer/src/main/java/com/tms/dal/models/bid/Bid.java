package com.tms.dal.models.bid;

import com.tms.dal.models.Tender;
import com.tms.dal.models.Tenderer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tenderer_id")
  private Tenderer tenderer;

  // constructors, getters, and setters
}
