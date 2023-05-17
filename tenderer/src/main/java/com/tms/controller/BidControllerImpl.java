package com.tms.controller;

import com.tms.dal.dto.BidDTO;
import com.tms.service.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/bids")
public class BidControllerImpl {

  private final BidService bidService;


  @GetMapping
  public ResponseEntity<List<BidDTO>> getAllBids() {
    List<BidDTO> bids = bidService.getAllBids();
    return ResponseEntity.ok(bids);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BidDTO> getBidById(@PathVariable Long id) {
    BidDTO bid = bidService.getBidById(id);
    return ResponseEntity.ok(bid);
  }

  @PostMapping
  public ResponseEntity<BidDTO> createBid(@RequestBody BidDTO bidDTO) {
    BidDTO createdBid = bidService.createBid(bidDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdBid);
  }

  @PutMapping("/{id}")
  public ResponseEntity<BidDTO> updateBid(@PathVariable Long id, @RequestBody BidDTO bidDTO) {
    BidDTO updatedBid = bidService.updateBid(id, bidDTO);
    return ResponseEntity.ok(updatedBid);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBid(@PathVariable Long id) {
    bidService.deleteBid(id);
    return ResponseEntity.noContent().build();
  }


}
