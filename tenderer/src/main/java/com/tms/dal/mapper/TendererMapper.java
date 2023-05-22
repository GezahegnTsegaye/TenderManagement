package com.tms.dal.mapper;

import com.tms.dal.dto.TendererDTO;
import com.tms.dal.models.Tender;
import com.tms.dal.models.Tenderer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TendererMapper {

  TendererMapper INSTANCE = Mappers.getMapper(TendererMapper.class);

  Tenderer toEntity(TendererDTO tendererDTO);
  TendererDTO toDTO(Tenderer tenderer);

  List<TendererDTO> toDTOList(List<Tenderer> tenderers);

}
