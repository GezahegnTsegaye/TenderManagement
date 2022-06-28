package com.tms.repository;

import com.tms.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<com.tms.model.Users, Long> {

     com.tms.model.Users findByUsername(String username);

    List<Users> findByRole(String role);

    Users findByEmail(String email);

    Users findByPhoneNumber(String phoneNumber);


}
