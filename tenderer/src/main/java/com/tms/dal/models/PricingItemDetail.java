package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter@AllArgsConstructor@Getter@NoArgsConstructor
@Entity
@Table(name = "pricing_item_detail")
public class PricingItemDetail {

  @Id
//  @GeneratedValue(generator = "account_type_id_gen", strategy = GenerationType.SEQUENCE)
//  @SequenceGenerator(name = "account_type_id_gen", sequenceName = "account_type_id_seq", allocationSize = 1)
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  private Double price;
  @ManyToOne( fetch = FetchType.LAZY)
  @JoinColumn(name = "workItemDetailId")
  private WorkItemDetail workItemDetail;

}
