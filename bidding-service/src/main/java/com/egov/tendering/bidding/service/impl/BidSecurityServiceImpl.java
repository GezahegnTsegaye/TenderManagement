package com.egov.tendering.bidding.service.impl;

import com.egov.tendering.bidding.dal.dto.BidSecurityDTO;
import com.egov.tendering.bidding.dal.dto.BidSecurityRequest;
import com.egov.tendering.bidding.dal.mapper.BidSecurityMapper;

import com.egov.tendering.bidding.dal.model.Bid;
import com.egov.tendering.bidding.dal.model.BidSecurity;
import com.egov.tendering.bidding.dal.model.BidStatus;
import com.egov.tendering.bidding.dal.model.SecurityStatus;
import com.egov.tendering.bidding.dal.repository.BidRepository;
import com.egov.tendering.bidding.dal.repository.BidSecurityRepository;
import com.egov.tendering.bidding.exception.InvalidBidStateException;
import com.egov.tendering.bidding.exception.ResourceNotFoundException;
import com.egov.tendering.bidding.service.BidSecurityService;
import com.egov.tendering.bidding.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class BidSecurityServiceImpl implements BidSecurityService {

    private final BidSecurityRepository bidSecurityRepository;
    private final BidRepository bidRepository;
    private final BidSecurityMapper bidSecurityMapper;
    private final FileStorageService fileStorageService;

    @Override
    @Transactional(readOnly = true)
    public BidSecurityDTO getBidSecurityByBidId(Long bidId) {
        log.info("Fetching bid security for bid ID: {}", bidId);
        BidSecurity security = bidSecurityRepository.findByBidId(bidId)
                .orElseThrow(() -> new ResourceNotFoundException("No bid security found for bid ID: " + bidId));
        return bidSecurityMapper.toDto(security);
    }

    @Override
    @Transactional
    public BidSecurityDTO addBidSecurity(Long bidId, BidSecurityRequest request, MultipartFile document) {
        log.info("Adding bid security for bid ID: {}", bidId);

        // Fetch the bid and validate its state
        Bid bid = bidRepository.findById(bidId)
                .orElseThrow(() -> new ResourceNotFoundException("Bid not found with ID: " + bidId));
        if (bid.getStatus() != BidStatus.DRAFT) {
            throw new InvalidBidStateException("Bid security can only be added to bids in DRAFT state");
        }

        // Check if a security already exists
        if (bidSecurityRepository.existsByBidId(bidId)) {
            throw new IllegalStateException("A bid security already exists for bid ID: " + bidId);
        }

        // Create new bid security
        BidSecurity security = BidSecurity.builder()
                .bid(bid)
                .type(request.getType())
                .amount(request.getAmount())
                .issuerName(request.getIssuerName())
                .referenceNumber(request.getReferenceNumber())
                .issueDate(request.getIssueDate())
                .expiryDate(request.getExpiryDate())
                .status(SecurityStatus.PENDING)
                .build();

        // Handle document upload if provided
        if (document != null && !document.isEmpty()) {
            String documentPath = fileStorageService.storeFile(document, "security-" + bidId + "-" + System.currentTimeMillis());
            security.setDocumentPath(documentPath);
            log.info("Stored bid security document at: {}", documentPath);
        }

        // Save and return DTO
        security = bidSecurityRepository.save(security);
        log.info("Bid security added successfully for bid ID: {}", bidId);
        return bidSecurityMapper.toDto(security);
    }

    @Override
    @Transactional
    public BidSecurityDTO verifyBidSecurity(Long securityId, SecurityStatus status, String comment, Long verifiedBy) {
        log.info("Verifying bid security ID: {} with status: {}", securityId, status);

        // Fetch the security
        BidSecurity security = bidSecurityRepository.findById(securityId)
                .orElseThrow(() -> new ResourceNotFoundException("Bid security not found with ID: " + securityId));

        // Validate state transition
        if (security.getStatus() != SecurityStatus.PENDING) {
            throw new InvalidBidStateException("Can only verify bid securities in PENDING state");
        }
        if (status == SecurityStatus.PENDING) {
            throw new IllegalArgumentException("Cannot verify to PENDING status");
        }

        // Update verification details
        security.setStatus(status);
        security.setVerifiedBy(verifiedBy);
        security.setVerifiedAt(LocalDateTime.now());

        // Save and return
        security = bidSecurityRepository.save(security);
        log.info("Bid security ID: {} verified with status: {}", securityId, status);
        return bidSecurityMapper.toDto(security);
    }

    @Override
    @Transactional
    public BidSecurityDTO updateBidSecurityStatus(Long securityId, SecurityStatus status) {
        log.info("Updating bid security ID: {} to status: {}", securityId, status);

        // Fetch the security
        BidSecurity security = bidSecurityRepository.findById(securityId)
                .orElseThrow(() -> new ResourceNotFoundException("Bid security not found with ID: " + securityId));

        // Validate state transition
        if (security.getStatus() == status) {
            log.warn("Bid security ID: {} already has status: {}", securityId, status);
            return bidSecurityMapper.toDto(security);
        }
        if (security.getStatus() == SecurityStatus.RETURNED || security.getStatus() == SecurityStatus.FORFEITED) {
            throw new InvalidBidStateException("Cannot update status of RETURNED or FORFEITED bid securities");
        }

        // Update status
        security.setStatus(status);
        security = bidSecurityRepository.save(security);
        log.info("Bid security ID: {} status updated to: {}", securityId, status);
        return bidSecurityMapper.toDto(security);
    }
}