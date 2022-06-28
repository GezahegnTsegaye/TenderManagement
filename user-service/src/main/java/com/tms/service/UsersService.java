package com.tms.service;


import com.tms.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Users findByUsername(String username);

    List<Users> findByRole(String role);

    List<Users> findAll();

    Users save(Users users);

    void delete(Users users);

    Optional<Users> findById(Long id);

    Users findByEmail(String email);

    Users findByPhoneNumber(String phoneNumber);

}
