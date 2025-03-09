package com.egov.tendering.audit.services.impl;

import com.egov.tendering.audit.dal.model.AttributeValue;
import com.egov.tendering.audit.dal.model.Criteria;
import com.egov.tendering.audit.dal.model.TenderOffer;
import com.egov.tendering.audit.dal.repository.AttributeValueRepository;
import com.egov.tendering.audit.dal.repository.TenderOfferRepository;
import com.egov.tendering.audit.services.TenderOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TenderOfferServiceImpl implements TenderOfferService {
  private final TenderOfferRepository tenderOfferRepository;
  private final AttributeValueRepository attributeValueRepository;


  @Override
  public TenderOffer findMaxScoreTenderOffer(Long id, List<Criteria> criteriaList) {
    TenderOffer maxScoreTenderOffer = null;
    double maxScore = Double.MIN_VALUE;

    for (Criteria criteria : criteriaList) {
      TenderOffer tenderOffer = tenderOfferRepository.findByRFTIDAndCriteria(id, criteria);

      if (tenderOffer != null && tenderOffer.getOverallScore() > maxScore) {
        maxScore = tenderOffer.getOverallScore();
        maxScoreTenderOffer = tenderOffer;
      }

    }

    return maxScoreTenderOffer;
  }



  public double evaluateAttribute(TenderOffer tenderOffer, String attributeName) {
    // Retrieve the attribute value from the tender offer based on the attribute name

    AttributeValue attVal = attributeValueRepository.findByAttributeName(attributeName);
    tenderOffer.setAttributeValue(attVal);
    Object attributeValue = tenderOffer.getAttributeValue();

    // Apply evaluation logic based on the attribute value and criteria
    double score = 0.0;

    // Evaluate the attribute based on its type and criteria
    if (attributeValue instanceof Double) {
      // Handle Double attribute type
      double value = (double) attributeValue;
      // Add your evaluation logic for Double attribute type
      // ...
    } else if (attributeValue instanceof Integer) {
      // Handle Integer attribute type
      int value = (int) attributeValue;
      // Add your evaluation logic for Integer attribute type
      // ...
    } else if (attributeValue instanceof String) {
      // Handle String attribute type
      String value = (String) attributeValue;
      // Add your evaluation logic for String attribute type
      // ...
    } else {
      // Handle unsupported attribute types or other exceptional cases
      // ...
    }

    return score;
  }

}
