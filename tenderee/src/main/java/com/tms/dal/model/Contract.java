package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "contract")
public class Contract {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "amount")
  private BigDecimal amount;

  private LocalDate startDate;
  private LocalDate endDate;
  private String status;
  private String createdBy;
  private LocalDate createdDate;
  private String updatedBy;
  private LocalDate updatedDate;
  private String deletedBy;
  private LocalDate deletedDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "contractor_id")
  private Contractor contractor;




  // constructors, getters, and setters
}
