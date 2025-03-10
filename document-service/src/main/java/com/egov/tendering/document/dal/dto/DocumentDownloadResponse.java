
package com.egov.tendering.document.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for document download response
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDownloadResponse {

    private Long documentId;
    private String name;
    private String originalFilename;
    private String contentType;
    private Long fileSize;
    private byte[] content;
}
