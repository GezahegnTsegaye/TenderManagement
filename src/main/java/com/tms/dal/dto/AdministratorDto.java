package com.tms.dal.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Gezu
 */

 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class AdministratorDto {

    private Long adminId;
    @NotNull
    private String adminName;
    private String adminEmail;
    private String address;
    private String adminPassword;
}