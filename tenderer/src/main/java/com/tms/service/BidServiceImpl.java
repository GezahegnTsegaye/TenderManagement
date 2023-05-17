package com.tms.service;

import com.tms.dal.dto.BidDTO;
import com.tms.dal.mapper.BidMapper;
import com.tms.dal.models.bid.Bid;
import com.tms.dal.repository.BidRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BidServiceImpl implements BidService {


  private final BidRepository bidRepository;
  private final BidMapper bidMapper;


  @Override
  public List<BidDTO> getAllBids() {
    List<Bid> bids = bidRepository.findAll();
    return bidMapper.toDTOList(bids);
  }

  @Override
  public BidDTO getBidById(Long id) {
    Bid bid = bidRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Bid not found"));
    return bidMapper.toDTO(bid);
  }

  @Override
  public BidDTO createBid(BidDTO bidDTO) {
    Bid bid = bidMapper.toEntity(bidDTO);
    Bid createdBid = bidRepository.save(bid);
    return bidMapper.toDTO(createdBid);
  }

  @Override
  public BidDTO updateBid(Long id, BidDTO bidDTO) {
    Bid existingBid = bidRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Bid not found"));

    bidMapper.updateEntityFromDTO(bidDTO, existingBid);
    Bid updatedBid = bidRepository.save(existingBid);

    return bidMapper.toDTO(updatedBid);
  }

  @Override
  public void deleteBid(Long id) {
    bidRepository.deleteById(id);
  }


}
