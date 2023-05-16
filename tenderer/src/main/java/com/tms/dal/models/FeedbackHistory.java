package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "feedback_history", indexes = {
        @Index(name = "idx_feedbackhistory", columnList = "feedback_date")
})
public class FeedbackHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "feedback_id")
  private Long feedbackId;

  @Column(name = "feedback_text")
  private String feedbackText;

  @Column(name = "feedback_date")
  private LocalDate feedbackDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tenderer_id")
  private Tenderer tenderer;

  // getters and setters
}
