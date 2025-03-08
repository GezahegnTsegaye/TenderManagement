package com.egov.tendering.user.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.egov.tendering.user.dal.model.User;
import com.egov.tendering.user.dal.model.UserRole;
import com.egov.tendering.user.dal.model.UserStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

  Optional<User> findByUsernameOrEmail(String username, String email);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);

  List<User> findByRole(UserRole role);

  Page<User> findByStatus(UserStatus status, Pageable pageable);
}
