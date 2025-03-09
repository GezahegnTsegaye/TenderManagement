package com.egov.tendering.audit.services;

import com.egov.tendering.audit.dal.model.Criteria;
import com.egov.tendering.audit.dal.model.TenderOffer;

import java.util.List;

public interface TenderOfferService {
  TenderOffer findMaxScoreTenderOffer(Long tenderOfferId, List<Criteria> criteriaList);


}
