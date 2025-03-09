package com.egov.tendering.audit.services.impl;


import com.egov.tendering.audit.dal.dto.EvaluationResultDTO;
import com.egov.tendering.audit.dal.dto.EvaluatorDTO;
import com.egov.tendering.audit.dal.model.AttributePreference;
import com.egov.tendering.audit.dal.model.EvaluationCriterion;
import com.egov.tendering.audit.dal.model.Tender;
import com.egov.tendering.audit.dal.model.TenderOffer;
import com.egov.tendering.audit.dal.repository.TenderOfferRepository;
import com.egov.tendering.audit.exceptions.EntityNotFoundException;
import com.egov.tendering.audit.services.EvaluatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class EvaluatorServiceImpl implements EvaluatorService {


  private final TenderOfferRepository tenderOfferRepository;

  @Override
  public EvaluationResultDTO evaluateTenderOffer(Long tenderOfferId, Long evaluatorId) {
    TenderOffer tenderOffer = tenderOfferRepository.findById(tenderOfferId)
            .orElseThrow(() -> new EntityNotFoundException("Tender offer not found with ID: " + tenderOfferId));

    Tender tender = tenderOffer.getTender();
    List<EvaluationCriterion> criteria = tender.getEvaluationCriteria();
    Map<String, Double> criterionWeights = new HashMap<>();
    Map<String, Object> criterionPreferences = new HashMap<>();

    for (EvaluationCriterion criterion : criteria) {
      String attributeName = criterion.getAttributeName();
      Double weight = criterion.getWeight();
      criterionWeights.put(attributeName, weight);

      // Assuming the attribute preferences are stored as an enumeration in the EvaluationCriterion entity
      AttributePreference preference = criterion.getPreference();
      criterionPreferences.put(attributeName, preference);
    }

    // Perform automatic evaluation
//    Map<String, Object> attributeOffers = retrieveAttributeOffers(tenderOffer); // Retrieve attribute offers based on the tender offer

    Map<String, Double> attributeScores = new HashMap<>();
//    for (String attributeName : attributeOffers.keySet()) {
//      Object attributeValue = attributeOffers.get(attributeName);
//      Double score = evaluateAttribute(attributeName, attributeValue, criterionPreferences);
//      attributeScores.put(attributeName, score);
//    }

    double overallScore = calculateOverallScore(attributeScores, criterionWeights);

    EvaluationResultDTO evaluationResultDTO = new EvaluationResultDTO();
    evaluationResultDTO.setTenderOfferId(tenderOfferId);
    evaluationResultDTO.setEvaluatorId(evaluatorId);
    evaluationResultDTO.setOverallScore(overallScore);
    evaluationResultDTO.setAttributeScores(attributeScores);


    return evaluationResultDTO;
  }

//  private Map<String, Object> retrieveAttributeOffers(TenderOffer _tenderOffer) {
//    // Retrieve attribute offers from the tender offer
//    // This method can be implemented based on your application's data structure and relationships
//    // For example, you can have a map of attribute name and corresponding offer values in the TenderOffer entity
//    TenderOffer tenderOffer = tenderOfferRepository.findById(_tenderOffer.getId())
//            .orElseThrow(() -> new EntityNotFoundException("Tender offer not found with ID: " + _tenderOffer.getId()));
//
//    return tenderOffer.getAttributeOffers();
//  }

  private Double evaluateAttribute(String attributeName, Object attributeValue, Map<String, Object> criterionPreferences) {
    // Apply evaluation logic based on attribute type and preference
    // Implement the provided evaluation algorithm for each attribute type (amount, time, enumeration) and
    // preference (more the better, later the better)
    // Calculate and return the attribute score

    AttributePreference preference = (AttributePreference) criterionPreferences.get(attributeName);

    // Apply evaluation logic based on attribute type and preference
    if (attributeValue instanceof Double) {
      // Handle amount type
      Double value = (Double) attributeValue;
      if (preference == AttributePreference.MORE_THE_BETTER) {
        return value; // Higher values are better
      } else {
        return 1 / value; // Lower values are better
      }
    } else if (attributeValue instanceof Integer) {
      // Handle time type
      Integer value = (Integer) attributeValue;
      if (preference == AttributePreference.MORE_THE_BETTER) {
        return value.doubleValue(); // Higher values are better
      } else {
        return 1 / value.doubleValue(); // Lower values are better
      }
    } else if (attributeValue instanceof String) {
      // Handle enumeration type
      // Assuming the score ratio is stored as a double in the criterionPreferences map
      Double scoreRatio = (Double) criterionPreferences.get(attributeName);


      return scoreRatio; // Return the ratio as the score
    }


    return null;

  }

  private Double calculateOverallScore(Map<String, Double> attributeScores, Map<String, Double> criterionWeights) {
    double overallScore = 0.0;
    for (String attributeName : attributeScores.keySet()) {
      Double attributeScore = attributeScores.get(attributeName);
      Double weight = criterionWeights.get(attributeName);
      overallScore += attributeScore * weight;
    }
    return overallScore;
  }


  @Override
  public void createEvaluator(EvaluatorDTO evaluatorDTO) {

  }
}
