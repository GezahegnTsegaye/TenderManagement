package com.tms.repository;

import com.tms.model.Users;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<com.tms.model.Users, Long> {

     com.tms.model.Users findByUsername(String username);
=======
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findByUsername(String username);
>>>>>>> a35bd8f118291efa471cca98736c83735285c780

    List<Users> findByRole(String role);

    Users findByEmail(String email);

    Users findByPhoneNumber(String phoneNumber);


}
