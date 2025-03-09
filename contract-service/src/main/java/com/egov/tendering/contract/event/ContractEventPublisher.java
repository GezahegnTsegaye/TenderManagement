package com.egov.tendering.contract.event;

import com.egov.tendering.contract.dal.model.Contract;
import com.egov.tendering.contract.dal.model.ContractMilestone;
import com.egov.tendering.contract.dal.model.ContractStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

@Component
@RequiredArgsConstructor
@Slf4j
public class ContractEventPublisher {

    private final KafkaTemplate<String, ContractEvent> kafkaTemplate;
    private final AtomicLong eventIdCounter = new AtomicLong(1);

    @Value("${app.kafka.topics.contract-events}")
    private String contractEventsTopic;

    public void publishContractCreatedEvent(Contract contract) {
        if (contract == null || contract.getId() == null) {
            log.error("Cannot publish event for null contract or contract without ID");
            return;
        }

        ContractCreatedEvent event = ContractCreatedEvent.builder()
                .eventId(generateEventId())
                .eventType("CONTRACT_CREATED")
                .timestamp(LocalDateTime.now())
                .contractId(contract.getId())
                .contractNumber(contract.getContractNumber())
                .tenderId(contract.getTenderId())
                .bidderId(contract.getBidderId())
                .title(contract.getTitle())
                .startDate(contract.getStartDate())
                .endDate(contract.getEndDate())
                .totalValue(contract.getTotalValue())
                .build();

        sendEventWithErrorHandling(contract.getId().toString(), event, "contract created");
    }

    public void publishContractStatusChangedEvent(Contract contract, ContractStatus oldStatus) {
        if (contract == null || contract.getId() == null || oldStatus == null) {
            log.error("Cannot publish status changed event with null parameters");
            return;
        }

        ContractStatusChangedEvent event = ContractStatusChangedEvent.builder()
                .eventId(generateEventId())
                .eventType("CONTRACT_STATUS_CHANGED")
                .timestamp(LocalDateTime.now())
                .contractId(contract.getId())
                .contractNumber(contract.getContractNumber())
                .title(contract.getTitle())
                .oldStatus(oldStatus)
                .newStatus(contract.getStatus())
                .build();

        sendEventWithErrorHandling(contract.getId().toString(), event, "contract status changed");
    }

    public void publishContractActivatedEvent(Contract contract) {
        if (contract == null || contract.getId() == null) {
            log.error("Cannot publish event for null contract or contract without ID");
            return;
        }

        ContractActivatedEvent event = ContractActivatedEvent.builder()
                .eventId(generateEventId())
                .eventType("CONTRACT_ACTIVATED")
                .timestamp(LocalDateTime.now())
                .contractId(contract.getId())
                .contractNumber(contract.getContractNumber())
                .title(contract.getTitle())
                .startDate(contract.getStartDate())
                .build();

        sendEventWithErrorHandling(contract.getId().toString(), event, "contract activated");
    }

    public void publishContractCompletedEvent(Contract contract) {
        if (contract == null || contract.getId() == null) {
            log.error("Cannot publish event for null contract or contract without ID");
            return;
        }

        ContractCompletedEvent event = ContractCompletedEvent.builder()
                .eventId(generateEventId())
                .eventType("CONTRACT_COMPLETED")
                .timestamp(LocalDateTime.now())
                .contractId(contract.getId())
                .contractNumber(contract.getContractNumber())
                .title(contract.getTitle())
                .build();

        sendEventWithErrorHandling(contract.getId().toString(), event, "contract completed");
    }

    public void publishContractTerminatedEvent(Contract contract, String reason) {
        if (contract == null || contract.getId() == null) {
            log.error("Cannot publish event for null contract or contract without ID");
            return;
        }

        ContractTerminatedEvent event = ContractTerminatedEvent.builder()
                .eventId(generateEventId())
                .eventType("CONTRACT_TERMINATED")
                .timestamp(LocalDateTime.now())
                .contractId(contract.getId())
                .contractNumber(contract.getContractNumber())
                .title(contract.getTitle())
                .reason(reason)
                .build();

        sendEventWithErrorHandling(contract.getId().toString(), event, "contract terminated");
    }

    public void publishMilestoneAddedEvent(Contract contract, ContractMilestone milestone) {
        if (contract == null || contract.getId() == null || milestone == null || milestone.getId() == null) {
            log.error("Cannot publish milestone added event with null contract or milestone");
            return;
        }

        MilestoneAddedEvent event = MilestoneAddedEvent.builder()
                .eventId(generateEventId())
                .eventType("MILESTONE_ADDED")
                .timestamp(LocalDateTime.now())
                .contractId(contract.getId())
                .contractNumber(contract.getContractNumber())
                .milestoneId(milestone.getId())
                .milestoneTitle(milestone.getTitle())
                .dueDate(milestone.getDueDate())
                .build();

        sendEventWithErrorHandling(contract.getId().toString() + "_milestone_" + milestone.getId(),
                event, "milestone added");
    }

    public void publishMilestoneCompletedEvent(Contract contract, ContractMilestone milestone) {
        if (contract == null || contract.getId() == null || milestone == null || milestone.getId() == null) {
            log.error("Cannot publish milestone completed event with null contract or milestone");
            return;
        }

        MilestoneCompletedEvent event = MilestoneCompletedEvent.builder()
                .eventId(generateEventId())
                .eventType("MILESTONE_COMPLETED")
                .timestamp(LocalDateTime.now())
                .contractId(contract.getId())
                .contractNumber(contract.getContractNumber())
                .milestoneId(milestone.getId())
                .milestoneTitle(milestone.getTitle())
                .completedDate(milestone.getCompletedDate())
                .build();

        sendEventWithErrorHandling(contract.getId().toString() + "_milestone_" + milestone.getId(),
                event, "milestone completed");
    }

    public void publishMilestoneOverdueEvent(Contract contract, ContractMilestone milestone) {
        if (contract == null || contract.getId() == null || milestone == null || milestone.getId() == null) {
            log.error("Cannot publish milestone overdue event with null contract or milestone");
            return;
        }

        MilestoneOverdueEvent event = MilestoneOverdueEvent.builder()
                .eventId(generateEventId())
                .eventType("MILESTONE_OVERDUE")
                .timestamp(LocalDateTime.now())
                .contractId(contract.getId())
                .contractNumber(contract.getContractNumber())
                .milestoneId(milestone.getId())
                .milestoneTitle(milestone.getTitle())
                .dueDate(milestone.getDueDate())
                .build();

        sendEventWithErrorHandling(contract.getId().toString() + "_milestone_" + milestone.getId(),
                event, "milestone overdue");
    }

    private <T extends ContractEvent> void sendEventWithErrorHandling(String key, T event, String eventDescription) {
        log.info("Publishing {} event: {}", eventDescription, event);

        try {
            CompletableFuture<SendResult<String, ContractEvent>> future = kafkaTemplate.send(
                    contractEventsTopic,
                    key,
                    event);

            future.whenComplete((result, ex) -> {
                if (ex != null) {
                    log.error("Failed to publish {} event with key: {}", eventDescription, key, ex);
                } else {
                    log.debug("Successfully published {} event with key: {} to partition {} with offset {}",
                            eventDescription,
                            key,
                            result.getRecordMetadata().partition(),
                            result.getRecordMetadata().offset());
                }
            });
        } catch (Exception e) {
            log.error("Exception occurred while publishing {} event with key: {}", eventDescription, key, e);
        }
    }

    private Long generateEventId() {
        return eventIdCounter.getAndIncrement();
    }
}