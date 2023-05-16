package com.tms.dal.mapper;


import com.tms.dal.dto.ContactDetailDTO;
import com.tms.dal.model.ContactDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactDetailMapper {

  ContactDetailMapper INSTANCE = Mappers.getMapper(ContactDetailMapper.class);

  ContactDetail toEntity(ContactDetailDTO contactDetailDTO);
  ContactDetailDTO toDTO(ContactDetail contactDetail);
  List<ContactDetailDTO> toDTOList(List<ContactDetail> contactDetails);



}
