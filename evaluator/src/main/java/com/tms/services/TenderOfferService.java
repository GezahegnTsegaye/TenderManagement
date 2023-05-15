package com.tms.services;

import com.tms.dal.model.Criteria;
import com.tms.dal.model.TenderOffer;

import java.util.List;

public interface TenderOfferService {
  TenderOffer findMaxScoreTenderOffer(Long tenderOfferId, List<Criteria> criteriaList);


}
