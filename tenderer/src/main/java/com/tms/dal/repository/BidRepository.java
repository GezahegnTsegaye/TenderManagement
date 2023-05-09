package com.tms.dal.repository;

import com.tms.dal.models.bid.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
