package com.egov.tendering.evaluation.service;

import com.egov.tendering.evaluation.dal.dto.AllocationResultDTO;
import com.egov.tendering.evaluation.dal.dto.TenderRankingDTO;
import com.egov.tendering.evaluation.dal.model.Evaluation;

import java.math.BigDecimal;
import java.util.List;

public interface AllocationService {

    List<AllocationResultDTO> allocateSingleWinner(Long tenderId, List<TenderRankingDTO> rankings);

    List<AllocationResultDTO> allocateCooperative(Long tenderId, List<Evaluation> evaluations);

    List<AllocationResultDTO> allocateCompetitive(
            Long tenderId,
            List<TenderRankingDTO> rankings,
            BigDecimal cutoffScore,
            boolean isAverageAllocation);

    List<AllocationResultDTO> getAllocationsByTender(Long tenderId);

    List<AllocationResultDTO> getAllocationsByBid(Long bidId);

    void clearAllocations(Long tenderId);
}