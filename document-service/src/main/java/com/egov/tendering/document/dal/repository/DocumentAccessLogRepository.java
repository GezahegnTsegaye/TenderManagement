
package com.egov.tendering.document.dal.repository;

import com.egov.tendering.document.dal.model.DocumentAccessLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository for managing document access logs
 */
@Repository
public interface DocumentAccessLogRepository extends JpaRepository<DocumentAccessLog, Long> {

    /**
     * Find all access logs for a specific document
     */
    List<DocumentAccessLog> findByDocumentIdOrderByAccessedAtDesc(Long documentId);

    /**
     * Find all access logs for a specific document with pagination
     */
    Page<DocumentAccessLog> findByDocumentIdOrderByAccessedAtDesc(Long documentId, Pageable pageable);

    /**
     * Find all access logs for a specific user
     */
    List<DocumentAccessLog> findByUserIdOrderByAccessedAtDesc(String userId);

    /**
     * Find access logs within a specific time period
     */
    List<DocumentAccessLog> findByAccessedAtBetweenOrderByAccessedAtDesc(LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Count accesses by document ID
     */
    long countByDocumentId(Long documentId);

    /**
     * Get popular documents based on number of accesses
     */
    @Query("SELECT d.documentId, COUNT(d) as accessCount FROM DocumentAccessLog d " +
            "WHERE d.accessedAt BETWEEN :startDate AND :endDate " +
            "GROUP BY d.documentId ORDER BY accessCount DESC")
    List<Object[]> findPopularDocuments(@Param("startDate") LocalDateTime startDate,
                                        @Param("endDate") LocalDateTime endDate,
                                        Pageable pageable);
}


