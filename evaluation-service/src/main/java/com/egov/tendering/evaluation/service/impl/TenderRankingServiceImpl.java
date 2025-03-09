package com.egov.tendering.evaluation.service.impl;

import com.egov.tendering.evaluation.client.BidClient;
import com.egov.tendering.evaluation.dal.dto.TenderRankingDTO;
import com.egov.tendering.evaluation.dal.mapper.TenderRankingMapper;
import com.egov.tendering.evaluation.dal.model.Evaluation;
import com.egov.tendering.evaluation.dal.model.TenderRanking;
import com.egov.tendering.evaluation.dal.repository.TenderRankingRepository;
import com.egov.tendering.evaluation.service.TenderRankingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TenderRankingServiceImpl implements TenderRankingService {

    private final TenderRankingRepository rankingRepository;
    private final TenderRankingMapper rankingMapper;
    private final BidClient bidClient;

    @Override
    @Transactional
    public List<TenderRankingDTO> calculateBidRankings(Long tenderId, List<Evaluation> evaluations) {
        log.info("Calculating bid rankings for tender ID: {}", tenderId);

        // Clear existing rankings
        clearRankings(tenderId);

        // Group evaluations by bid
        Map<Long, List<Evaluation>> evaluationsByBid = evaluations.stream()
                .collect(Collectors.groupingBy(Evaluation::getBidId));

        // Calculate average score for each bid
        List<TenderRanking> rankings = new ArrayList<>();

        for (Map.Entry<Long, List<Evaluation>> entry : evaluationsByBid.entrySet()) {
            Long bidId = entry.getKey();
            List<Evaluation> bidEvaluations = entry.getValue();

            // Calculate average score
            BigDecimal totalScore = bidEvaluations.stream()
                    .map(Evaluation::getOverallScore)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal averageScore = totalScore.divide(
                    BigDecimal.valueOf(bidEvaluations.size()), 2, RoundingMode.HALF_UP);

            // Create ranking
            TenderRanking ranking = new TenderRanking();
            ranking.setTenderId(tenderId);
            ranking.setBidId(bidId);
            ranking.setFinalScore(averageScore);

            rankings.add(ranking);
        }

        // Sort by score (descending) and assign ranks
        rankings.sort(Comparator.comparing(TenderRanking::getFinalScore).reversed());

        int rank = 1;
        for (TenderRanking ranking : rankings) {
            ranking.setRank(rank++);
            ranking.setIsWinner(false); // Will be set later in allocation
        }

        // Save rankings
        rankings = rankingRepository.saveAll(rankings);

        // Map to DTOs and enrich with bidder names
        List<TenderRankingDTO> rankingDTOs = rankingMapper.toDtoList(rankings);

        return enrichRankingDTOs(rankingDTOs);
    }

    @Override
    public List<TenderRankingDTO> getBidRankingsByTender(Long tenderId) {
        log.info("Getting bid rankings for tender ID: {}", tenderId);

        List<TenderRanking> rankings = rankingRepository.findByTenderIdOrderByRankAsc(tenderId);

        List<TenderRankingDTO> rankingDTOs = rankingMapper.toDtoList(rankings);

        return enrichRankingDTOs(rankingDTOs);
    }

    @Override
    public List<TenderRankingDTO> getWinningBids(Long tenderId) {
        log.info("Getting winning bids for tender ID: {}", tenderId);

        List<TenderRanking> winners = rankingRepository.findByTenderIdAndIsWinnerTrue(tenderId);

        List<TenderRankingDTO> winnerDTOs = rankingMapper.toDtoList(winners);

        return enrichRankingDTOs(winnerDTOs);
    }

    @Override
    @Transactional
    public void clearRankings(Long tenderId) {
        log.info("Clearing rankings for tender ID: {}", tenderId);

        rankingRepository.deleteByTenderId(tenderId);
    }

    // Helper method to enrich ranking DTOs with bidder names
    private List<TenderRankingDTO> enrichRankingDTOs(List<TenderRankingDTO> rankingDTOs) {
        for (TenderRankingDTO dto : rankingDTOs) {
            try {
                dto.setBidderName(bidClient.getBidById(dto.getBidId()).getTendererName());
            } catch (Exception e) {
                log.warn("Failed to get bidder name for bid ID: {}", dto.getBidId());
                dto.setBidderName("Unknown");
            }
        }
        return rankingDTOs;
    }
}