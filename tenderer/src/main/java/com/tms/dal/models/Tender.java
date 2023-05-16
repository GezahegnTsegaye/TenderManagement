package com.tms.dal.models;

import com.tms.dal.models.bid.Bid;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tender", indexes = {
        @Index(name = "idx_tender_name", columnList = "tender_name")
})
public class Tender {

  @Id
  @Column(name = "tender_id")
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tender_seq_gen")
//  @SequenceGenerator(name = "tender_seq_gen", sequenceName = "tender_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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


  @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Bid> bids = new ArrayList<>();

  // getters and setters
}
