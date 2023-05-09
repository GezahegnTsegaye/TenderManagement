package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "delivery_method")
public class DeliveryMethod {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "delivery_method_id")
  private Long deliveryMethodId;

  @Column(name = "delivery_method_name")
  private String deliveryMethodName;

  @Column(name = "delivery_method_description")
  private String deliveryMethodDescription;

  // getters and setters
}
