package com.egov.tendering.contract.dal.mapper;

import com.egov.tendering.contract.dal.dto.ContractDTO;
import com.egov.tendering.contract.dal.dto.ContractItemDTO;
import com.egov.tendering.contract.dal.dto.ContractMilestoneDTO;
import com.egov.tendering.contract.dal.model.Contract;
import com.egov.tendering.contract.dal.model.ContractItem;
import com.egov.tendering.contract.dal.model.ContractMilestone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {

  ContractDTO toDto(Contract contract);

  List<ContractDTO> toDtoList(List<Contract> contracts);

  Contract toEntity(ContractDTO dto);

  ContractItemDTO toItemDto(ContractItem item);

  List<ContractItemDTO> toItemDtoList(List<ContractItem> items);

  @Mapping(target = "contract", ignore = true)
  ContractItem toItemEntity(ContractItemDTO dto);

  ContractMilestoneDTO toMilestoneDto(ContractMilestone milestone);

  List<ContractMilestoneDTO> toMilestoneDtoList(List<ContractMilestone> milestones);

  @Mapping(target = "contract", ignore = true)
  ContractMilestone toMilestoneEntity(ContractMilestoneDTO dto);
}