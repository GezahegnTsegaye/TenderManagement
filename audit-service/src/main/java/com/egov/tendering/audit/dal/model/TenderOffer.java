package com.egov.tendering.audit.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tender_offer")
public class TenderOffer {

  @Id
  @Column(name = "tender_offer_Id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tender_offer_Id_gen")
  @SequenceGenerator(name = "tender_offer_Id_gen", sequenceName = "tender_offer_Id_seq", allocationSize = 1)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "venderId")
  private Vender vender;

  private Double price;

  private String quality;
  @Column(name = "delivery_time")
  private Integer deliveryTime;

  @Column(name = "overall_score")
  private Double overallScore;
  @Column(name = "composite_bid")
  private Double compositeBid;

//  @ElementCollection
//  @CollectionTable(name = "attribute_offers",
//          joinColumns = @JoinColumn(name = "tender_offer_id"))
//  @MapKeyColumn(name = "attribute_name")
//  @Column(name = "attribute_value")
//  private Map<String, Object> attributeOffers;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "attribute_value_id")
  private AttributeValue attributeValue;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "criteria_id")
  private Criteria criteria;



}
