package com.tms.repository;

import com.tms.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface VenderRepository extends CrudRepository<Users, Long> {

}
