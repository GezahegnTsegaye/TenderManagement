package com.tms.repository;

import com.tms.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findByUsername(String username);

    List<Users> findByRole(String role);

    Users findByEmail(String email);

    Users findByPhoneNumber(String phoneNumber);


}
