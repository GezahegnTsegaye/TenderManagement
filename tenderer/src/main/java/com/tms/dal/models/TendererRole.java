package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "tenderer_role", indexes = {
        @Index(name = "role", columnList = "role")
})
public class TendererRole {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String role;
}
