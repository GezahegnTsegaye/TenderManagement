package com.tms.dal.model;

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
@Table(name = "offer_information")
public class OfferInformation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;

}
