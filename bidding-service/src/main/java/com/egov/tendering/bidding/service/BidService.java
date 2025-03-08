package com.egov.tendering.bidding.service;

import com.egov.tendering.bidding.dal.dto.*;
import com.egov.tendering.bidding.dal.model.BidStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BidService {
  BidDTO createBid(BidSubmissionRequest request, Long tendererId);
  BidDTO getBidById(Long bidId);
  BidDTO submitBid(Long bidId);
  BidDTO updateBidStatus(Long bidId, BidStatus status);
  void deleteBid(Long bidId);
  Page<BidDTO> getBidsByTenderer(Long tendererId, Pageable pageable);
  Page<BidDTO> getBidsByTender(Long tenderId, Pageable pageable);
  List<BidDTO> getBidsByTenderAndStatus(Long tenderId, BidStatus status);
  BidDTO addDocumentToBid(Long bidId, MultipartFile file, String fileName);
  void removeDocumentFromBid(Long bidId, Long documentId);
  boolean hasTendererBidForTender(Long tenderId, Long tendererId);
  BidDTO updateBid(Long bidId, BidSubmissionRequest request, Long tendererId);

  // New methods
  List<BidVersionDTO> getBidVersions(Long bidId);
  BidVersionDTO getBidVersion(Long bidId, Integer versionNumber);
  List<BidClarificationDTO> getClarificationsByBidId(Long bidId);
  BidClarificationDTO requestClarification(Long bidId, String question, Long evaluatorId, int daysToRespond);
  BidClarificationDTO respondToClarification(Long clarificationId, String response, Long tendererId);
  BidSecurityDTO getBidSecurityByBidId(Long bidId);
  BidDTO submitBidWithSecurity(Long bidId, BidSecurityRequest securityRequest, MultipartFile securityDocument);
  ComplianceCheckResult validateBidCompliance(Long bidId);
}