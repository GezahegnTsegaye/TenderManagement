package com.egov.tendering.user.controller;

import com.egov.tendering.user.dal.dto.UserDTO;
import com.egov.tendering.user.dal.model.UserRole;
import com.egov.tendering.user.dal.model.UserStatus;
import org.springframework.http.ResponseEntity;


import com.egov.tendering.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;

  @GetMapping("/{userId}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
    log.info("Fetching user by ID: {}", userId);
    UserDTO user = userService.getUserById(userId);
    return ResponseEntity.ok(user);
  }

  @GetMapping("/username/{username}")
  public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
    log.info("Fetching user by username: {}", username);
    UserDTO user = userService.getUserByUsername(username);
    return ResponseEntity.ok(user);
  }

  @GetMapping
  public ResponseEntity<Page<UserDTO>> getAllUsers(@PageableDefault(size = 10) Pageable pageable) {
    log.info("Fetching all users with pagination");
    Page<UserDTO> users = userService.getAllUsers(pageable);
    return ResponseEntity.ok(users);
  }

  @GetMapping("/role/{role}")
  public ResponseEntity<List<UserDTO>> getUsersByRole(@PathVariable UserRole role) {
    log.info("Fetching users by role: {}", role);
    List<UserDTO> users = userService.getUsersByRole(role);
    return ResponseEntity.ok(users);
  }

  @PatchMapping("/{userId}/status")
  public ResponseEntity<UserDTO> updateUserStatus(
          @PathVariable Long userId,
          @RequestParam UserStatus status) {
    log.info("Updating status to {} for user ID: {}", status, userId);
    UserDTO updatedUser = userService.updateUserStatus(userId, status);
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
    log.info("Deleting user with ID: {}", userId);
    userService.deleteUser(userId);
    return ResponseEntity.noContent().build();
  }
}
