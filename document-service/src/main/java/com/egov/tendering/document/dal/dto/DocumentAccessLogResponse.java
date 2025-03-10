
package com.egov.tendering.document.dal.dto;

import com.egov.tendering.document.dal.model.AccessType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for document access log response
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentAccessLogResponse {

    private Long id;
    private Long documentId;
    private String userId;
    private String ipAddress;
    private AccessType accessType;
    private String userAgent;
    private LocalDateTime accessedAt;
}
