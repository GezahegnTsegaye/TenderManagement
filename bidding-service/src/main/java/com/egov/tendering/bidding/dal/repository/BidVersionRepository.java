package com.egov.tendering.bidding.dal.repository;


import com.egov.tendering.bidding.dal.model.BidVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidVersionRepository extends JpaRepository<BidVersion, Long> {

    List<BidVersion> findByBidIdOrderByVersionNumberDesc(Long bidId);

    @Query("SELECT MAX(bv.versionNumber) FROM BidVersion bv WHERE bv.bidId = :bidId")
    Optional<Integer> findMaxVersionByBidId(@Param("bidId") Long bidId);

    Optional<BidVersion> findByBidIdAndVersionNumber(Long bidId, Integer versionNumber);


    Optional<BidVersion> findTopByBidIdOrderByVersionNumberDesc(Long bidId);

    boolean existsByBidIdAndVersionNumber(Long bidId, Integer versionNumber);

}