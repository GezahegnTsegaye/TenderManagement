package com.egov.tendering.document.scheduler;

import com.egov.tendering.document.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Scheduler for document-related recurring tasks
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentScheduler {

    private final DocumentService documentService;

    /**
     * Process expired documents daily at midnight
     */
    @Scheduled(cron = "${document.expiry.cron:0 0 0 * * ?}")
    public void processExpiredDocuments() {
        log.info("Starting scheduled task: Process expired documents");
        documentService.processExpiredDocuments();
        log.info("Completed scheduled task: Process expired documents");
    }
}