package com.tms.dal.mapper;

import com.tms.dal.dto.ContactDetailsDTO;
import com.tms.dal.models.ContactDetails;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactDetailMapper {
  ContactDetailMapper INSTANCE = Mappers.getMapper(ContactDetailMapper.class);

  ContactDetailsDTO toDTO(ContactDetails contactDetails);
  ContactDetails toEntity(ContactDetailsDTO contactDetailsDTO);

  List<ContactDetailsDTO> toDTOList(List<ContactDetails> contactDetails);

  ContactDetails updateEntityFromDTO(ContactDetailsDTO contactDetailDTO, @MappingTarget ContactDetails contactDetail);

}
