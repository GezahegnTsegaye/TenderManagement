package com.tms.dal.mapper;

import com.tms.dal.dto.CommitteeDTO;
import com.tms.dal.model.Committee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommitteeMapper {

  CommitteeMapper INSTANCE = Mappers.getMapper(CommitteeMapper.class);
  CommitteeDTO toDto(Committee committee);
  Committee toEntity(CommitteeDTO committeeDTO);
  List<CommitteeDTO> toDTOList(List<Committee> committees);

}
