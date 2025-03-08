package com.egov.tendering.bidding.service.impl;


import com.egov.tendering.bidding.exception.FileStorageException;
import com.egov.tendering.bidding.service.FileStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@Slf4j
public class FileStorageServiceImpl implements FileStorageService {

    private final Path fileStorageLocation;

    public FileStorageServiceImpl(@Value("${app.file-storage.upload-dir:uploads}") String uploadDir) {
        this.fileStorageLocation = Paths.get(uploadDir).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored", ex);
        }
    }

    @Override
    public String storeFile(MultipartFile file, String prefix) {
        try {
            if (file.isEmpty()) {
                throw new FileStorageException("Failed to store empty file");
            }

            // Generate unique filename
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName != null ?
                    originalFileName.substring(originalFileName.lastIndexOf(".")) : "";
            String fileName = prefix + "-" + UUID.randomUUID() + fileExtension;

            // Copy file to the target location
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Failed to store file", ex);
        }
    }

    @Override
    public void deleteFile(String filePath) {
        try {
            Path file = this.fileStorageLocation.resolve(filePath);
            Files.deleteIfExists(file);
        } catch (IOException ex) {
            log.error("Error deleting file: {}", filePath, ex);
        }
    }
}