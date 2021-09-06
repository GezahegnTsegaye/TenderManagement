package com.tms.repository;

import com.tms.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

	List<Administrator> findAll();

}
