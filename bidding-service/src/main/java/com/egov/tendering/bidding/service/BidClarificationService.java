package com.egov.tendering.bidding.service;

import com.egov.tendering.bidding.dal.dto.BidClarificationDTO;

import java.util.List;

public interface BidClarificationService {

    List<BidClarificationDTO> getClarificationsByBidId(Long bidId);

    BidClarificationDTO requestClarification(Long bidId, String question, Long evaluatorId, int daysToRespond);

    BidClarificationDTO respondToClarification(Long clarificationId, String response, Long tendererId);

    void expireClarifications(Long bidId);
}