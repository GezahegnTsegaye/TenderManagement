package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Gezu
 */

 @Data
 @AllArgsConstructor
public class AdministratorDto {

    private Long adminId;
    private String adminName;
    private String adminEmail;
    private String adminPassword;
}