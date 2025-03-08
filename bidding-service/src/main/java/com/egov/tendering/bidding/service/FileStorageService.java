package com.egov.tendering.bidding.service;


import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String storeFile(MultipartFile file, String prefix);

    void deleteFile(String filePath);
}