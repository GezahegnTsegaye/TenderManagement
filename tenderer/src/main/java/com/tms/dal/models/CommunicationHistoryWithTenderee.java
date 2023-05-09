package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "communication_history_with_tenderee")
public class CommunicationHistoryWithTenderee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "communication_id")
  private Long communicationId;

  @Column(name = "communication_date")
  private LocalDateTime communicationDate;

  @Column(name = "communication_type")
  private String communicationType;

  @Column(name = "communication_subject")
  private String communicationSubject;

  @Column(name = "communication_content")
  private String communicationContent;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  // getters and setters
}
