package com.egov.tendering.evaluation.dal.repository;

import com.egov.tendering.evaluation.dal.model.TenderRanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenderRankingRepository extends JpaRepository<TenderRanking, Long> {

    List<TenderRanking> findByTenderIdOrderByRankAsc(Long tenderId);

    List<TenderRanking> findByTenderIdAndIsWinnerTrue(Long tenderId);

    Optional<TenderRanking> findByTenderIdAndBidId(Long tenderId, Long bidId);

    void deleteByTenderId(Long tenderId);
}