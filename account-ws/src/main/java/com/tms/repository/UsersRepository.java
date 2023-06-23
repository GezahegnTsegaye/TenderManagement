package com.tms.repository;

import com.tms.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByEmail(String username);
}
