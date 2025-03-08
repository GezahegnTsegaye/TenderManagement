package com.egov.tendering.bidding.controller;

import com.egov.tendering.bidding.dal.dto.BidDTO;
import com.egov.tendering.bidding.dal.dto.BidVersionDTO;
import com.egov.tendering.bidding.service.BidVersionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bids/{bidId}/versions")
@RequiredArgsConstructor
@Slf4j
public class BidVersionController {

    private final BidVersionService bidVersionService;

    @GetMapping
    public ResponseEntity<List<BidVersionDTO>> getBidVersions(@PathVariable Long bidId) {
        log.info("Getting version history for bid ID: {}", bidId);
        List<BidVersionDTO> versions = bidVersionService.getBidVersions(bidId);
        return ResponseEntity.ok(versions);
    }

    @GetMapping("/{versionNumber}")
    public ResponseEntity<List<BidVersionDTO>> getBidVersion(
            @PathVariable Long bidId,
            @PathVariable Integer versionNumber) {
        log.info("Getting version {} for bid ID: {}", versionNumber, bidId);
        List<BidVersionDTO> version = bidVersionService.getBidVersions(bidId);
        return ResponseEntity.ok(version);
    }

    @GetMapping("/compare")
    public ResponseEntity<Void> compareVersions(
            @PathVariable Long bidId,
          @RequestBody BidDTO bidData,  @RequestParam String changeSummary,  @RequestParam Long createdBy) {
        log.info("Comparing versions {} and {} for bid ID: {}", bidId, bidData, bidId);
        bidVersionService.saveBidVersion(bidId, bidData, changeSummary, createdBy);
        return ResponseEntity.ok().build();
    }
}