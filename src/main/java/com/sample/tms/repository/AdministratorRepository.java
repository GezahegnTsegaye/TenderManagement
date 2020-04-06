package com.sample.tms.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.tms.entity.Administrator;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {

}
