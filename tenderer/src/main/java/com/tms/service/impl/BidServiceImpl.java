package com.tms.service.impl;

import com.tms.dal.dto.BidDTO;
import com.tms.dal.dto.BidItemDTO;
import com.tms.dal.mapper.BidItemMapper;
import com.tms.dal.mapper.BidMapper;
import com.tms.dal.models.bid.Bid;
import com.tms.dal.models.bid.BidItem;
import com.tms.dal.models.bid.Supplier;
import com.tms.dal.repository.BidRepository;
import com.tms.dal.repository.SupplierRepository;
import com.tms.service.BidService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BidServiceImpl implements BidService {


  private final BidRepository bidRepository;
  private final BidMapper bidMapper;
  private final SupplierRepository supplierRepository;
  private final BidItemMapper bidItemMapper;


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
  @Transactional
  public BidDTO createBid(BidDTO bidDTO) {
    Bid bid = new Bid();
    // Set other bid properties from bidDTO
    bid.setCreatedDate(LocalDateTime.now()); // Set the current timestamp as the createdDate

    // Create and set the associated BidItem entities
    List<BidItem> bidItems = new ArrayList<>();
    for (BidItemDTO bidItemDTO : bidDTO.getBidItems()) {
      BidItem bidItem = bidItemMapper.toEntity(bidItemDTO);
      // Set bidItem properties from bidItemDTO
      bidItem.setBid(bid);
      bidItems.add(bidItem);
    }
    bid.setBidItems(bidItems);

    // Set the Supplier entity
    Supplier supplier = supplierRepository.findById(bidDTO.getSupplierDTO().getSupplierId())
            .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));
    bid.setSupplier(supplier);

    // Save the bid and bidItems
    Bid savedBid = bidRepository.save(bid);
    return bidMapper.toDTO(savedBid);
  }


  @Override
  @Transactional
  public BidDTO updateBid(Long id, BidDTO bidDTO) {
    Bid existingBid = bidRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Bid not found"));

    // Update the existing bid with properties from bidDTO
    bidMapper.updateEntityFromDTO(bidDTO, existingBid);

    // Update the associated bidItems
    List<BidItem> updatedBidItems = new ArrayList<>();
    for (BidItemDTO bidItemDTO : bidDTO.getBidItems()) {
      BidItem existingBidItem = existingBid.getBidItems().stream()
              .filter(bidItem -> bidItem.getBidItemId().equals(bidItemDTO.getBidItemId()))
              .findFirst()
              .orElseThrow(() -> new EntityNotFoundException("BidItem not found"));

      bidItemMapper.updateEntityFromDTO(bidItemDTO, existingBidItem);
      updatedBidItems.add(existingBidItem);
    }
    existingBid.setBidItems(updatedBidItems);

    // Save the updated bid
    Bid updatedBid = bidRepository.save(existingBid);

    // Convert and return the updated bid as DTO
    return bidMapper.toDTO(updatedBid);
  }


  @Override
  public void deleteBid(Long id) {
    bidRepository.deleteById(id);
  }


}
