package com.egov.tendering.user.controller;



import com.egov.tendering.user.dal.dto.AuthResponse;
import com.egov.tendering.user.dal.dto.LoginRequest;
import com.egov.tendering.user.dal.dto.RegistrationRequest;
import com.egov.tendering.user.dal.dto.UserDTO;

import com.egov.tendering.user.service.AuthService;
import com.egov.tendering.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("Login request received for user: {}", loginRequest.getUsernameOrEmail());
        AuthResponse authResponse = authService.login(loginRequest);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody RegistrationRequest registrationRequest) {
        log.info("Registration request received for user: {}", registrationRequest.getUsername());
        UserDTO registeredUser = userService.registerUser(registrationRequest);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
}