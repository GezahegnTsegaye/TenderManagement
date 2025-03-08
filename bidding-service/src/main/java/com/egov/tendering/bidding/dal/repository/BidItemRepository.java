package com.egov.tendering.bidding.dal.repository;


import com.egov.tendering.bidding.dal.model.BidItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidItemRepository extends JpaRepository<BidItem, Long> {

    List<BidItem> findByBidId(Long bidId);

    List<BidItem> findByCriteriaId(Long criteriaId);

    Optional<BidItem> findTopByBidIdOrderByIdDesc(Long bidId);
}