
package com.egov.tendering.document.dal.dto;

import com.egov.tendering.document.dal.model.DocumentType;
import com.egov.tendering.document.dal.model.EntityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for document search filters
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentSearchFilter {

    private String searchTerm;
    private EntityType entityType;
    private String entityId;
    private DocumentType documentType;
    private Boolean isPublic;
    private String createdBy;
}