package com.tms.repository;

import com.tms.model.Users;
import com.tms.model.Vender;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VenderRepository extends CrudRepository<Vender, Long> {

}
