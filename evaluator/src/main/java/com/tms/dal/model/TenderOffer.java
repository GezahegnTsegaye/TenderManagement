package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Entity@Table(name = "tender_offer")
public class TenderOffer {

  @Id
  @Column(name = "tender_offer_Id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tender_offer_Id_gen")
  @SequenceGenerator(name = "tender_offer_Id_gen", sequenceName = "tender_offer_Id_seq",allocationSize = 1)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "venderId")
  private Vender vender;

  private Double price;

  private String quality;

  private Integer deliveryTime;
}
