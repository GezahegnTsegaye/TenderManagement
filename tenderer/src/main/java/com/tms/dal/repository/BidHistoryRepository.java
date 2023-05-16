package com.tms.dal.repository;

import com.tms.dal.models.bid.BidHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidHistoryRepository extends JpaRepository<BidHistory, Long> {
}
