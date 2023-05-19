package com.tms.repository;

import com.tms.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

  @Query("select u from Users u where u.userName = :username")
  Users findByUsername(@Param("username") String username);



}
