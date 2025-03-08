package com.egov.tendering.bidding.dal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidDocumentDTO {
    private Long id;
    private String name;
    private String filePath;
    private String fileType;
    private Long fileSize;
    private LocalDateTime createdAt;
}