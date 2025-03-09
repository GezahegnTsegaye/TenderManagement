package com.egov.tendering.evaluation.dal.repository;

import com.egov.tendering.evaluation.dal.model.CommitteeReview;
import com.egov.tendering.evaluation.dal.model.ReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for CommitteeReview entity
 */
@Repository
public interface CommitteeReviewRepository extends JpaRepository<CommitteeReview, Long> {

    /**
     * Finds all reviews for a specific tender
     *
     * @param tenderId the tender ID
     * @return list of reviews
     */
    List<CommitteeReview> findByTenderId(Long tenderId);

    /**
     * Finds all reviews for a specific tender with a given status
     *
     * @param tenderId the tender ID
     * @param status the review status
     * @return list of filtered reviews
     */
    List<CommitteeReview> findByTenderIdAndStatus(Long tenderId, ReviewStatus status);

    /**
     * Finds all reviews by a specific committee member
     *
     * @param committeeMemberId the committee member ID
     * @return list of reviews
     */
    List<CommitteeReview> findByCommitteeMemberId(Long committeeMemberId);

    /**
     * Finds a review by tender and committee member
     *
     * @param tenderId the tender ID
     * @param committeeMemberId the committee member ID
     * @return the review if found
     */
    Optional<CommitteeReview> findByTenderIdAndCommitteeMemberId(Long tenderId, Long committeeMemberId);

    /**
     * Counts reviews with a specific status for a tender
     *
     * @param tenderId the tender ID
     * @param status the review status
     * @return count of matching reviews
     */
    long countByTenderIdAndStatus(Long tenderId, ReviewStatus status);
}