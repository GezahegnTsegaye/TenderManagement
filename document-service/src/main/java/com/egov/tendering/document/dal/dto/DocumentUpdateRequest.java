
package com.egov.tendering.document.dal.dto;

import com.egov.tendering.document.dal.model.DocumentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for document update requests
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentUpdateRequest {

    private String name;
    private String description;
    private Boolean isPublic;
    private DocumentStatus status;
    private LocalDateTime expiresAt;
}