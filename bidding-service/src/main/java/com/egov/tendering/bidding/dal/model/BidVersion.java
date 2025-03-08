package com.egov.tendering.bidding.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bid_versions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidVersion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "bid_id", nullable = false)
  private Long bidId;

  @Column(name = "version_number", nullable = false)
  private Integer versionNumber;

  @Column(name = "version_data", columnDefinition = "JSON")
  private String versionData;

  @Column(name = "change_summary")
  private String changeSummary;

  @Column(name = "created_by")
  private Long createdBy;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }
}