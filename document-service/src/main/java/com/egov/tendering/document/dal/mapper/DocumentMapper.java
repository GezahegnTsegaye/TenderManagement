package com.egov.tendering.document.dal.mapper;

import com.egov.tendering.document.dal.dto.DocumentAccessLogResponse;
import com.egov.tendering.document.dal.dto.DocumentResponse;
import com.egov.tendering.document.dal.model.Document;
import com.egov.tendering.document.dal.model.DocumentAccessLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between document entities and DTOs
 */
@Mapper(componentModel = "spring")
public interface DocumentMapper {

    /**
     * Convert Document entity to DocumentResponse DTO
     */
    @Mapping(target = "downloadUrl", ignore = true)
    DocumentResponse toDocumentResponse(Document document);

    /**
     * Convert DocumentAccessLog entity to DocumentAccessLogResponse DTO
     */
    DocumentAccessLogResponse toDocumentAccessLogResponse(DocumentAccessLog accessLog);
}