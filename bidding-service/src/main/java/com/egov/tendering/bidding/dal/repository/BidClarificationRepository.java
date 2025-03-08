package com.egov.tendering.bidding.dal.repository;

import com.egov.tendering.bidding.dal.model.BidClarification;
import com.egov.tendering.bidding.dal.model.ClarificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidClarificationRepository extends JpaRepository<BidClarification, Long> {
    List<BidClarification> findByBidId(Long bidId);
    List<BidClarification> findByBidIdAndStatus(Long bidId, ClarificationStatus status);
}