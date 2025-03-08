package com.egov.tendering.bidding.service;

import com.egov.tendering.bidding.dal.dto.BidSecurityDTO;
import com.egov.tendering.bidding.dal.dto.BidSecurityRequest;
import com.egov.tendering.bidding.dal.model.SecurityStatus;
import org.springframework.web.multipart.MultipartFile;

public interface BidSecurityService {

    BidSecurityDTO getBidSecurityByBidId(Long bidId);

    BidSecurityDTO addBidSecurity(Long bidId, BidSecurityRequest request, MultipartFile document);

    BidSecurityDTO verifyBidSecurity(Long securityId, SecurityStatus status, String comment, Long verifiedBy);

    BidSecurityDTO updateBidSecurityStatus(Long securityId, SecurityStatus status);
}