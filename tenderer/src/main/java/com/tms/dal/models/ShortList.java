package com.tms.dal.models;

import com.tms.dal.models.bid.Bid;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "short_list")
public class ShortList {

  @Id
  @Column(name = "short_list_id")
//  @GeneratedValue(generator = "short_list_id_gen", strategy = GenerationType.SEQUENCE)
//  @SequenceGenerator(name = "short_list_id_gen", sequenceName = "short_list_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bidId")
  private Bid bid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tendererId")
  private Tenderer tenderer;

}
