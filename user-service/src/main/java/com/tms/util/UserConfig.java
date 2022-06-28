package com.tms.util;


import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    public static final String USER_SERVICE_URL = "http://localhost:8081";
    public static final String USER_SERVICE_USERNAME = "user";
    public static final String USER_SERVICE_PASSWORD = "password";
    public static final String USER_SERVICE_ROLE = "USER";
    public static final String USER_SERVICE_ROLE_ADMIN = "ADMIN";
    public static final String USER_SERVICE_ROLE_TENDEREE = "TENDEREE";
    public static final String USER_SERVICE_ROLE_TENDERER = "TENDERER";
    public static final String USER_SERVICE_ROLE_TENDEREE_ADMIN = "TENDEREE_ADMIN";
    public static final String USER_SERVICE_ROLE_TENDERER_ADMIN = "TENDERER_ADMIN";
    public static final String USER_SERVICE_ROLE_TENDEREE_TENDERER = "TENDEREE_TENDERER";
    public static final String USER_SERVICE_ROLE_TENDERER_TENDEREE = "TENDERER_TENDEREE";

    public static final String USER_SERVICE_ROLE_TENDEREE_TENDERER_ADMIN = "TENDEREE_TENDERER_ADMIN";
    public static final String USER_SERVICE_ROLE_TENDERER_TENDEREE_ADMIN = "TENDERER_TENDEREE_ADMIN";
    public static final String USER_SERVICE_ROLE_TENDEREE_TENDERER_TENDEREE_ADMIN = "TENDEREE_TENDERER_TENDEREE_ADMIN";

}
