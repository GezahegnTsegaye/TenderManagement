package com.tms.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "terms")
public class Terms {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "term_id")
  private Long termId;

  @Column(name = "term_name")
  private String termName;

  @Column(name = "term_description")
  private String termDescription;

  // getters and setters
}
