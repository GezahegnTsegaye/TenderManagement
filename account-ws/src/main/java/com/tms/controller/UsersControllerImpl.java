package com.tms.controller;

import com.tms.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UsersControllerImpl implements UsersController{

  private final UsersService  usersService;
  @Override
  @GetMapping
  public ResponseEntity<String> getAdmin() {
    return ResponseEntity.ok("it is working");
  }

  @Override
  public ResponseEntity<String> getTenderee() {
    return null;
  }

  @Override
  public ResponseEntity<String> getTender() {
    return null;
  }

  @Override
  public ResponseEntity<String> getTendereeAdmin() {
    return null;
  }

  @Override
  public ResponseEntity<String> getTenderAdmin() {
    return null;
  }
}
