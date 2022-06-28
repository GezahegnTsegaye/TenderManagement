package com.tms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface UsersController {
    @GetMapping("/admin")
    ResponseEntity<String> getAdmin();

    @GetMapping("/tenderee")
    ResponseEntity<String> getTenderee();

    @GetMapping("/tenderer")
    ResponseEntity<String> getTender();

    @GetMapping("/tenderee-admin")
    ResponseEntity<String> getTendereeAdmin();

    ResponseEntity<String> getTenderAdmin();
}
