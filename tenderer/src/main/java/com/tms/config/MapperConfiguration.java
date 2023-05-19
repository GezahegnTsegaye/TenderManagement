package com.tms.config;

import com.tms.dal.mapper.BidMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

  @Bean
  public BidMapper bidMapper(){
    return Mappers.getMapper(BidMapper.class);
  }
}
