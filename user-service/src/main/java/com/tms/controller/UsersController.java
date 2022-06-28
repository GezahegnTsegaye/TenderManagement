package com.tms.controller;

import org.springframework.http.ResponseEntity;

public interface UsersController {
  ResponseEntity<String> getAdmin();

  ResponseEntity<String> getTenderee();

  ResponseEntity<String> getTender();

  ResponseEntity<String> getTendereeAdmin();

  ResponseEntity<String> getTenderAdmin();
}
