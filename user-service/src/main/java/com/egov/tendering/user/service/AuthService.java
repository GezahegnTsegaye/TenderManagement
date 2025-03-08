package com.egov.tendering.user.service;


import com.egov.tendering.user.dal.dto.AuthResponse;
import com.egov.tendering.user.dal.dto.LoginRequest;

public interface AuthService {

    AuthResponse login(LoginRequest request);

    String generateToken(String username);

    boolean validateToken(String token);

    String getUsernameFromToken(String token);
}