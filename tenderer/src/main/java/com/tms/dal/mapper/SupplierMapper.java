package com.tms.dal.mapper;


import com.tms.dal.dto.SupplierDTO;
import com.tms.dal.models.bid.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {


  SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

  SupplierDTO toDTO(Supplier supplier);

  Supplier toEntity(SupplierDTO supplierDTO);

  List<SupplierDTO> totoDTOList(List<Supplier> suppliers);

  void updateEntityFromDTO(SupplierDTO supplierDTO, @MappingTarget Supplier supplier);



}
