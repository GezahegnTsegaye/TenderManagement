package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Entity@Table(name = "warranty_information", indexes = {
        @Index(name = "warranty_name", columnList = "warranty_name")
})
public class WarrantyInformation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "warranty_name", unique = true)
  private String warrantyName;
}
