
package com.egov.tendering.document.dal.dto;

import com.egov.tendering.document.dal.model.DocumentStatus;
import com.egov.tendering.document.dal.model.DocumentType;
import com.egov.tendering.document.dal.model.EntityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for document response
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentResponse {

    private Long id;
    private String name;
    private String originalFilename;
    private String contentType;
    private String fileExtension;
    private Long fileSize;
    private DocumentType documentType;
    private String entityId;
    private EntityType entityType;
    private DocumentStatus status;
    private String description;
    private String version;
    private Boolean isPublic;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiresAt;
    private String downloadUrl;
}