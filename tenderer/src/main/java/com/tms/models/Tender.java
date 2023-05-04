package com.tms.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tender")
public class Tender {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tender_id")
  private Long tenderId;

  @Column(name = "tender_name")
  private String tenderName;

  @Column(name = "tender_description")
  private String tenderDescription;

  @Column(name = "tender_type")
  private String tenderType;

  @Column(name = "tender_status")
  private String tenderStatus;

  @Column(name = "tender_start_date")
  private LocalDate tenderStartDate;

  @Column(name = "tender_end_date")
  private LocalDate tenderEndDate;


  @OneToMany(mappedBy = "tenderer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Bid> bids = new ArrayList<>();

  // getters and setters
}
