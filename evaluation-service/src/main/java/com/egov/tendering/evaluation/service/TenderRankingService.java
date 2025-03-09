package com.egov.tendering.evaluation.service;

import com.egov.tendering.evaluation.dal.dto.TenderRankingDTO;
import com.egov.tendering.evaluation.dal.model.Evaluation;

import java.util.List;

public interface TenderRankingService {

    List<TenderRankingDTO> calculateBidRankings(Long tenderId, List<Evaluation> evaluations);

    List<TenderRankingDTO> getBidRankingsByTender(Long tenderId);

    List<TenderRankingDTO> getWinningBids(Long tenderId);

    void clearRankings(Long tenderId);
}