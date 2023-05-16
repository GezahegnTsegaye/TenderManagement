package com.tms.dal.mapper;

import com.tms.dal.dto.CertificationDTO;
import com.tms.dal.models.Certifications;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CertificationMapper {
  CertificationDTO toDTO(Certifications certification);
  Certifications toEntity(CertificationDTO dto);
  List<CertificationDTO> toDTOList(List<Certifications> certifications);
}
