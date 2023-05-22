package com.tms.service;

import com.tms.dal.dto.BidDTO;

import java.util.List;

public interface BidService {
  List<BidDTO> getAllBids();

  BidDTO getBidById(Long id);

  BidDTO createBid(BidDTO bidDTO);

  BidDTO updateBid(Long id, BidDTO bidDTO);

  void deleteBid(Long id);
}
