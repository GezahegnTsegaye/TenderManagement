package com.tms.dal.mapper;

import com.tms.dal.dto.CertificationDTO;
import com.tms.dal.models.Certifications;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CertificationMapper {
  CertificationMapper INSTANCE = Mappers.getMapper(CertificationMapper.class);
  CertificationDTO toDTO(Certifications certification);
  Certifications toEntity(CertificationDTO dto);
  List<CertificationDTO> toDTOList(List<Certifications> certifications);
}
