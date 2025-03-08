package com.egov.tendering.bidding.dal.repository;


import com.egov.tendering.bidding.dal.model.BidSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BidSecurityRepository extends JpaRepository<BidSecurity, Long> {

    Optional<BidSecurity> findByBidId(Long bidId);

    boolean existsByBidId(Long bidId);
}