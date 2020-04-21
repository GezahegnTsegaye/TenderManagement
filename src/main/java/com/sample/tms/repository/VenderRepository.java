package com.sample.tms.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.tms.entity.Users;

public interface VenderRepository extends CrudRepository<Users, Long> {

}
