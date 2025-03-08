package com.egov.tendering.user.service;


import com.egov.tendering.user.dal.dto.RegistrationRequest;
import com.egov.tendering.user.dal.dto.UserDTO;

import java.util.List;


import com.egov.tendering.user.dal.model.UserRole;
import com.egov.tendering.user.dal.model.UserStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface UserService {

    UserDTO registerUser(RegistrationRequest request);

    UserDTO getUserById(Long userId);

    UserDTO getUserByUsername(String username);

    Page<UserDTO> getAllUsers(Pageable pageable);

    List<UserDTO> getUsersByRole(UserRole role);

    UserDTO updateUserStatus(Long userId, UserStatus status);

    void deleteUser(Long userId);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}