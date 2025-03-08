package com.egov.tendering.tender.service.impl;


import com.egov.tendering.tender.dal.dto.CreateTenderRequest;
import com.egov.tendering.tender.dal.dto.TenderDTO;
import com.egov.tendering.tender.dal.dto.UpdateTenderStatusRequest;
import com.egov.tendering.tender.dal.mapper.TenderMapper;
import com.egov.tendering.tender.dal.model.*;
import com.egov.tendering.tender.dal.repository.TenderCriteriaRepository;
import com.egov.tendering.tender.dal.repository.TenderItemRepository;
import com.egov.tendering.tender.dal.repository.TenderRepository;
import com.egov.tendering.tender.event.TenderEventPublisher;
import com.egov.tendering.tender.exception.TenderNotFoundException;
import com.egov.tendering.tender.service.TenderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TenderServiceImpl implements TenderService {

  private final TenderRepository tenderRepository;
  private final TenderCriteriaRepository criteriaRepository;
  private final TenderItemRepository itemRepository;
  private final TenderMapper tenderMapper;
  private final TenderEventPublisher eventPublisher;

  @Override
  @Transactional
  public TenderDTO createTender(CreateTenderRequest request, Long tendereeId) {
    log.info("Creating new tender: {} by tenderee: {}", request.getTitle(), tendereeId);

    Tender tender = Tender.builder()
            .title(request.getTitle())
            .description(request.getDescription())
            .tendereeId(tendereeId)
            .type(request.getType())
            .status(TenderStatus.DRAFT)
            .submissionDeadline(request.getSubmissionDeadline())
            .allocationStrategy(request.getAllocationStrategy())
            .minWinners(request.getMinWinners())
            .maxWinners(request.getMaxWinners())
            .cutoffScore(request.getCutoffScore())
            .isAverageAllocation(request.getIsAverageAllocation())
            .build();

    // Save tender first to get ID
    tender = tenderRepository.save(tender);

    // Create and add criteria
    Tender finalTender = tender;
    List<TenderCriteria> criteriaList = request.getCriteria().stream()
            .map(criteriaRequest -> TenderCriteria.builder()
                    .tender(finalTender)
                    .name(criteriaRequest.getName())
                    .description(criteriaRequest.getDescription())
                    .type(criteriaRequest.getType())
                    .weight(criteriaRequest.getWeight())
                    .preferHigher(criteriaRequest.getPreferHigher())
                    .build())
            .collect(Collectors.toList());

    criteriaList = criteriaRepository.saveAll(criteriaList);
    tender.setCriteria(criteriaList);

    // Create and add items
    List<TenderItem> itemList = new ArrayList<>();
    final List<TenderCriteria> finalCriteriaList = criteriaList; // Create a final copy
    for (var itemRequest : request.getItems()) {
      TenderCriteria criteria = finalCriteriaList.stream()
              .filter(c -> c.getId().equals(itemRequest.getCriteriaId()))
              .findFirst()
              .orElseThrow(() -> new IllegalArgumentException("Invalid criteria ID: " + itemRequest.getCriteriaId()));

      TenderItem item = TenderItem.builder()
              .tender(tender)
              .criteria(criteria)
              .name(itemRequest.getName())
              .description(itemRequest.getDescription())
              .quantity(itemRequest.getQuantity())
              .unit(itemRequest.getUnit())
              .estimatedPrice(itemRequest.getEstimatedPrice())
              .build();

      itemList.add(item);
    }

    itemList = itemRepository.saveAll(itemList);
    tender.setItems(itemList);

    // Publish event for tender creation
    eventPublisher.publishTenderCreatedEvent(tender);

    return tenderMapper.toDto(tender);
  }

  @Override
  public TenderDTO getTenderById(Long tenderId) {
    log.info("Retrieving tender with ID: {}", tenderId);

    Tender tender = tenderRepository.findById(tenderId)
            .orElseThrow(() -> new TenderNotFoundException("Tender not found with ID: " + tenderId));
    return tenderMapper.toDto(tender);
  }

  @Override
  public Page<TenderDTO> searchTenders(String title, TenderStatus status, TenderType type, Pageable pageable) {
    log.info("Searching tenders with title: {}, status: {}, type: {}", title, status, type);

    Page<Tender> tenders = tenderRepository.searchTenders(title, status, type, pageable);
    return tenders.map(tenderMapper::toDto);
  }

  @Override
  public Page<TenderDTO> getTendersByTenderee(Long tendereeId, Pageable pageable) {
    log.info("Retrieving tenders by tenderee ID: {}", tendereeId);

    Page<Tender> tenders = tenderRepository.findByTendereeId(tendereeId, pageable);
    return tenders.map(tenderMapper::toDto);
  }

  @Override
  @Transactional
  public TenderDTO updateTenderStatus(Long tenderId, UpdateTenderStatusRequest request) {
    log.info("Updating tender status: {} for tender ID: {}", request.getStatus(), tenderId);

    Tender tender = tenderRepository.findById(tenderId)
            .orElseThrow(() -> new TenderNotFoundException("Tender not found with ID: " + tenderId));

    TenderStatus oldStatus = tender.getStatus();
    tender.setStatus(request.getStatus());
    tender = tenderRepository.save(tender);

    // Publish event for status change
    eventPublisher.publishTenderStatusChangedEvent(tender, oldStatus);

    return tenderMapper.toDto(tender);
  }

  @Override
  @Transactional
  public TenderDTO publishTender(Long tenderId) {
    log.info("Publishing tender with ID: {}", tenderId);

    Tender tender = tenderRepository.findById(tenderId)
            .orElseThrow(() -> new TenderNotFoundException("Tender not found with ID: " + tenderId));

    if (tender.getStatus() != TenderStatus.DRAFT) {
      throw new IllegalStateException("Only tenders in DRAFT status can be published");
    }

    tender.setStatus(TenderStatus.PUBLISHED);
    tender = tenderRepository.save(tender);

    // Publish event for tender publishing
    eventPublisher.publishTenderPublishedEvent(tender);

    return tenderMapper.toDto(tender);
  }

  @Override
  @Transactional
  public TenderDTO closeTender(Long tenderId) {
    log.info("Closing tender with ID: {}", tenderId);

    Tender tender = tenderRepository.findById(tenderId)
            .orElseThrow(() -> new TenderNotFoundException("Tender not found with ID: " + tenderId));

    if (tender.getStatus() != TenderStatus.PUBLISHED) {
      throw new IllegalStateException("Only published tenders can be closed");
    }

    tender.setStatus(TenderStatus.CLOSED);
    tender = tenderRepository.save(tender);

    // Publish event for tender closing
    eventPublisher.publishTenderClosedEvent(tender);

    return tenderMapper.toDto(tender);
  }

  @Override
  @Scheduled(cron = "0 0 * * * *") // Run every hour
  @Transactional
  public void checkForExpiredTenders() {
    log.info("Checking for expired tenders");

    LocalDateTime now = LocalDateTime.now();
    List<Tender> expiredTenders = tenderRepository.findExpiredTenders(TenderStatus.PUBLISHED, now);

    for (Tender tender : expiredTenders) {
      log.info("Automatically closing expired tender: {}", tender.getId());
      tender.setStatus(TenderStatus.CLOSED);
      tender = tenderRepository.save(tender);

      // Publish event for tender closing
      eventPublisher.publishTenderClosedEvent(tender);
    }

    log.info("Closed {} expired tenders", expiredTenders.size());
  }
}