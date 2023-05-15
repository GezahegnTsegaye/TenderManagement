package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "criteria")
public class Criteria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "weight")
  private double weight;

  @Column(name = "rft_id")
  private String rftId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "price_item_id")
  private PriceItem priceItem;

  @OneToMany(mappedBy = "criteria")
  private List<TenderOffer> tenderOffers;

}