package com.tms.dal.repository;

import com.tms.dal.model.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {


  AttributeValue findByAttributeName(String attributeName);
}
