package com.tms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gezu
 * This includes
 */

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class AdministratorDto {

    private Long adminId;
    private String adminName;
    private String adminEmail;
    private String adminPassword;
    
}