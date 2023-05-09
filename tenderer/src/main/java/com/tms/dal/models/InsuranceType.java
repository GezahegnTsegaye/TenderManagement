package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Entity@Table(name = "insurance_type", indexes = {
        @Index(name = "type", columnList = "type")
})
public class InsuranceType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String type;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "insuranceId")
  private List<Insurance> insurances;
}
