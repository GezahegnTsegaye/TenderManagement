package com.tms.dal.mapper;

import com.tms.dal.dto.ContractDTO;
import com.tms.dal.model.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {
  ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

  //  @Mappings({
//          @Mapping(target = "tenderId", source = "contract.tender.id"),
//          @Mapping(target = "contractorId", source = "contract.contractor.id")
//  })
  ContractDTO toDTO(Contract contract);

  //  @Mappings({
//          @Mapping(target = "tender.id", source = "contractDTO.tenderId"),
//          @Mapping(target = "contractor.id", source = "contractDTO.contractorId")
//  })
  Contract toEntity(ContractDTO contractDTO);

  List<ContractDTO> toDTOList(List<Contract> contracts);
}

