package com.tms.services.impl;

import com.tms.dal.model.AllocationMode;
import com.tms.dal.model.TenderOffer;
import com.tms.dal.repository.CriteriaRepository;
import com.tms.services.ContractSelectionService;
import com.tms.services.TenderOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ContractSelectionServiceImpl implements ContractSelectionService {

  private final CriteriaRepository criteriaRepository;
  private final TenderOfferService tenderOfferService;


  /**
   * @param tenderOffers
   * @param numberOfWinners
   * @param allocationMode
   * @return
   */
  public List<TenderOffer> selectContractWinners(List<TenderOffer> tenderOffers, int numberOfWinners, AllocationMode allocationMode) {
    List<TenderOffer> contractWinners = new ArrayList<>();

    switch (allocationMode) {
      case SINGLE:
        // Sort the tender offers in descending order based on overall score
        tenderOffers.sort(Comparator.comparingDouble(TenderOffer::getOverallScore).reversed());

        // Select the winner with the highest overall score
        if (!tenderOffers.isEmpty()) {
          TenderOffer winner = tenderOffers.get(0);
          contractWinners.add(winner);
        }
        break;

//      case COOPERATIVE:
//        String rftId = "your_rft_id"; // Replace with the actual RFT ID you want to evaluate
//
//        // Retrieve the criteria list for the specified RFT ID (example: fetching from a database)
////          var criteriaList = criteriaRepository.findByPriceItemId(priceItem.getId());
//
//        for (PriceItem priceItem : criteriaList) {
//          // Find the tender offer with the maximum score for the current price item
//          // Find the tender offer with the maximum score for the current price item
//          Long tenderOfferId = 10L;
//          TenderOffer maxScoreTenderOffer = tenderOfferService.findMaxScoreTenderOffer(tenderOfferId, criteriaList);
//
//          if (maxScoreTenderOffer != null) {
//            contractWinners.add(maxScoreTenderOffer);
//          }
//        }
//        break;

      case COMPETITIVE:
        // Calculate the composite bid for each tender offer
        calculateCompositeBid(tenderOffers);

        // Sort the tender offers based on the composite bid in ascending order
        tenderOffers.sort(Comparator.comparingDouble(TenderOffer::getCompositeBid));

        // Determine the cutoff price based on the specified cutoff point
        double cutoffPoint = 0.5;
        double cutoffPrice = calculateCutOffPrice(tenderOffers, cutoffPoint);

        // Select the winners with a lower price than the cutoff price
        for (TenderOffer tenderOffer : tenderOffers) {
          if (tenderOffer.getPrice() < cutoffPrice) {
            contractWinners.add(tenderOffer);
          }
        }
        break;
    }

    // Limit the number of winners to the specified number
    if (contractWinners.size() > numberOfWinners) {
      contractWinners = contractWinners.subList(0, numberOfWinners);
    }

    return contractWinners;
  }


  /**
   * @param tenderOffers
   * @param cutoffPoint
   * @return
   */
  private double calculateCutOffPrice(List<TenderOffer> tenderOffers, double cutoffPoint) {
    // Sort the tender offers based on price in ascending order
    tenderOffers.sort(Comparator.comparingDouble(TenderOffer::getPrice));

    // Calculate the cutoff index
    int cutoffIndex = (int) (cutoffPoint * tenderOffers.size());

    // Get the tender offer at the cutoff index
    TenderOffer cutoffTenderOffer = tenderOffers.get(cutoffIndex);

    return cutoffTenderOffer.getPrice();
  }

  /**
   * @param tenderOffers
   * @return
   */
  private double calculateCompositeBid(List<TenderOffer> tenderOffers) {
    double compositeBid = 0.0;

    // Perform your calculation logic here to calculate the composite bid

    // calculation logic: Summing up the overall scores of tender offers
    for (TenderOffer tenderOffer : tenderOffers) {
      compositeBid += tenderOffer.getOverallScore();
    }

    // Return the calculated composite bid
    return compositeBid;
  }


}
