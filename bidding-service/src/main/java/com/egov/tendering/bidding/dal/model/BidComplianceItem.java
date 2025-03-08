package com.egov.tendering.bidding.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bid_compliance_items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidComplianceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid_id", nullable = false)
    private Bid bid;

    @Column(name = "requirement_id")
    private Long requirementId;

    @Column(nullable = false)
    private String requirement;

    @Column(nullable = false)
    private Boolean mandatory;

    @Column(nullable = false)
    private Boolean compliant;

    @Column(name = "comment")
    private String comment;

    @Column(name = "verified_by")
    private Long verifiedBy;

    @Column(name = "verified_at")
    private LocalDateTime verifiedAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}