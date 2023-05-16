package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "price_item")
public class PriceItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "priceItem", cascade = CascadeType.ALL)
  private List<Criteria> criteriaList;
}