package com.egov.tendering.bidding.dal.repository;

import com.egov.tendering.bidding.dal.model.BidComplianceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing BidComplianceItem entities.
 */
@Repository
public interface BidComplianceRepository extends JpaRepository<BidComplianceItem, Long> {

    /**
     * Finds all compliance items associated with a specific bid.
     *
     * @param bidId The ID of the bid.
     * @return List of BidComplianceItem entities for the given bid.
     */
    List<BidComplianceItem> findByBidId(Long bidId);

    /**
     * Checks if any compliance items exist for a given requirement.
     *
     * @param requirementId The ID of the compliance requirement.
     * @return true if compliance items exist, false otherwise.
     */
    boolean existsByRequirementId(Long requirementId);

    /**
     * Finds compliance items by bid ID and verification status.
     *
     * @param bidId The ID of the bid.
     * @param verified Whether the compliance item has been verified (true) or not (false).
     * @return List of BidComplianceItem entities matching the criteria.
     */
    @Query("SELECT bci FROM BidComplianceItem bci WHERE bci.bid.id = :bidId AND ((:verified = true AND bci.verifiedBy IS NOT NULL) OR (:verified = false AND bci.verifiedBy IS NULL))")
    List<BidComplianceItem> findByBidIdAndVerified(Long bidId, boolean verified);
}