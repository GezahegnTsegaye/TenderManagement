package com.tms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Gezu
 * This includes
 */

 @Data
public class AdministratorDto {

    private Long adminId;
    private String adminName;
    private String adminEmail;
    private String adminPassword;
    
}