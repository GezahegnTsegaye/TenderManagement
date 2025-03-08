package com.egov.tendering.bidding.service.impl;

import com.egov.tendering.bidding.dal.dto.ComplianceCheckResult;
import com.egov.tendering.bidding.dal.dto.ComplianceRequirementDTO;
import com.egov.tendering.bidding.dal.dto.BidComplianceItemDTO;
import com.egov.tendering.bidding.dal.mapper.ComplianceRequirementMapper;
import com.egov.tendering.bidding.dal.mapper.BidComplianceItemMapper;
import com.egov.tendering.bidding.dal.model.Bid;
import com.egov.tendering.bidding.dal.model.BidComplianceItem;
import com.egov.tendering.bidding.dal.model.ComplianceRequirement;
import com.egov.tendering.bidding.dal.model.BidStatus;
import com.egov.tendering.bidding.dal.repository.BidRepository;
import com.egov.tendering.bidding.dal.repository.BidSecurityRepository;
import com.egov.tendering.bidding.dal.repository.ComplianceRequirementRepository;
import com.egov.tendering.bidding.dal.repository.BidComplianceRepository;
import com.egov.tendering.bidding.exception.InvalidBidStateException;
import com.egov.tendering.bidding.exception.ResourceNotFoundException;
import com.egov.tendering.bidding.service.ComplianceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComplianceServiceImpl implements ComplianceService {

    private final ComplianceRequirementRepository complianceRequirementRepository;
    private final BidRepository bidRepository;
    private final BidComplianceRepository bidComplianceRepository;
    private final BidSecurityRepository bidSecurityRepository;
    private final ComplianceRequirementMapper complianceRequirementMapper;
    private final BidComplianceItemMapper bidComplianceItemMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ComplianceRequirementDTO> getComplianceRequirements(Long tenderId) {
        log.info("Fetching compliance requirements for tender ID: {}", tenderId);
        List<ComplianceRequirement> requirements = complianceRequirementRepository.findByTenderId(tenderId);
        return complianceRequirementMapper.toDtoList(requirements);
    }

    @Override
    @Transactional
    public ComplianceRequirementDTO addComplianceRequirement(Long tenderId, ComplianceRequirementDTO requirementDTO, Long createdBy) {
        log.info("Adding compliance requirement for tender ID: {}", tenderId);

        // Validate tender exists (assuming a TenderRepository exists; if not, this could be skipped or adjusted)
        if (!bidRepository.existsByTenderId(tenderId)) {
            throw new ResourceNotFoundException("Tender", "id", tenderId);
        }

        // Map DTO to entity
        ComplianceRequirement requirement = complianceRequirementMapper.toEntity(requirementDTO);
        requirement.setTenderId(tenderId);
        requirement.setCreatedBy(createdBy);

        // Save and return DTO
        requirement = complianceRequirementRepository.save(requirement);
        log.info("Compliance requirement added with ID: {} for tender ID: {}", requirement.getId(), tenderId);
        return complianceRequirementMapper.toDto(requirement);
    }

    @Override
    @Transactional
    public void deleteComplianceRequirement(Long requirementId) {
        log.info("Deleting compliance requirement ID: {}", requirementId);

        ComplianceRequirement requirement = complianceRequirementRepository.findById(requirementId)
                .orElseThrow(() -> new ResourceNotFoundException("ComplianceRequirement", "id", requirementId));

        if (bidComplianceRepository.existsByRequirementId(requirementId)) {
            throw new IllegalStateException("Cannot delete compliance requirement already associated with bids");
        }

        complianceRequirementRepository.delete(requirement);
        log.info("Compliance requirement ID: {} deleted", requirementId);
    }

    @Override
    @Transactional
    public ComplianceCheckResult checkBidCompliance(Long bidId) {
        log.info("Checking compliance for bid ID: {}", bidId);

        // Fetch and validate bid
        Bid bid = bidRepository.findById(bidId)
                .orElseThrow(() -> new ResourceNotFoundException("Bid", "id", bidId));
        if (bid.getStatus() != BidStatus.SUBMITTED && bid.getStatus() != BidStatus.UNDER_EVALUATION) {
            throw new InvalidBidStateException("Compliance can only be checked for SUBMITTED or UNDER_EVALUATION bids");
        }

        // Get tender's compliance requirements
        List<ComplianceRequirement> requirements = complianceRequirementRepository.findByTenderId(bid.getTenderId());
        List<BidComplianceItem> complianceItems = new ArrayList<>();
        boolean allMandatoryCompliant = true;

        // Check each requirement
        for (ComplianceRequirement req : requirements) {
            boolean isCompliant = checkCompliance(bid, req);
            BidComplianceItem item = BidComplianceItem.builder()
                    .bid(bid)
                    .requirementId(req.getId())
                    .requirement(req.getDescription())
                    .mandatory(req.getMandatory())
                    .compliant(isCompliant)
                    .build();
            complianceItems.add(item);
            if (req.getMandatory() && !isCompliant) {
                allMandatoryCompliant = false;
            }
        }

        // Save compliance items and return result
        bidComplianceRepository.saveAll(complianceItems);
        List<BidComplianceItemDTO> dtos = bidComplianceItemMapper.toDtoList(complianceItems);
        log.info("Compliance check completed for bid ID: {}. Compliant: {}", bidId, allMandatoryCompliant);
        return new ComplianceCheckResult(allMandatoryCompliant, dtos);
    }

    @Override
    @Transactional
    public void verifyComplianceItem(Long complianceItemId, Boolean compliant, String comment, Long verifiedBy) {
        log.info("Verifying compliance item ID: {} with compliant status: {}", complianceItemId, compliant);

        // Fetch and validate compliance item
        BidComplianceItem item = bidComplianceRepository.findById(complianceItemId)
                .orElseThrow(() -> new ResourceNotFoundException("BidComplianceItem", "id", complianceItemId));

        // Ensure bid is in a verifiable state
        Bid bid = item.getBid();
        if (bid.getStatus() != BidStatus.UNDER_EVALUATION) {
            throw new InvalidBidStateException("Compliance items can only be verified for bids UNDER_EVALUATION");
        }

        // Update verification details
        item.setCompliant(compliant);
        item.setComment(comment);
        item.setVerifiedBy(verifiedBy);
        item.setVerifiedAt(LocalDateTime.now());

        bidComplianceRepository.save(item);
        log.info("Compliance item ID: {} verified by user ID: {}", complianceItemId, verifiedBy);
    }

    private boolean checkCompliance(Bid bid, ComplianceRequirement req) {
        return switch (req.getType()) {
            case DOCUMENT -> bid.getDocuments().stream()
                    .anyMatch(doc -> doc.getName().contains(req.getKeyword()));
            case BID_SECURITY -> bidSecurityRepository.existsByBidId(bid.getId());
            case BID_ITEM -> bid.getItems().stream()
                    .anyMatch(item -> item.getCriteriaId().equals(req.getCriteriaId()));
            case QUALIFICATION -> checkQualification(bid, req); // Placeholder for custom logic
            case OTHER -> false; // Default; requires custom implementation
        };
    }

    private boolean checkQualification(Bid bid, ComplianceRequirement req) {
        // Placeholder for qualification-specific logic (e.g., tenderer certifications)
        // This would depend on your domain model; for now, return false
        log.warn("Qualification check not implemented for requirement ID: {}", req.getId());
        return false;
    }

}