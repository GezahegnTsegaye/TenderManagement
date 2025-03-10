package com.egov.tendering.document.dal.dto;

import com.egov.tendering.document.dal.model.DocumentType;
import com.egov.tendering.document.dal.model.EntityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for document creation requests
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentUploadRequest {

    @NotBlank(message = "Document name is required")
    private String name;

    @NotNull(message = "Document type is required")
    private DocumentType documentType;

    @NotBlank(message = "Entity ID is required")
    private String entityId;

    @NotNull(message = "Entity type is required")
    private EntityType entityType;

    private String description;

    private Boolean isPublic;

    private LocalDateTime expiresAt;
}


