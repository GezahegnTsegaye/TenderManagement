package com.tms.dal.mapper;


import com.tms.dal.dto.GoodsDTO;
import com.tms.dal.models.Goods;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GoodsMapper {

  GoodsMapper INSTANCE = Mappers.getMapper(GoodsMapper.class);

  GoodsDTO toDTO(Goods goods);
  Goods toEntity(GoodsDTO goodsDTO);
  List<GoodsDTO> toDTOList(List<Goods> goods);

  Goods updateFromDTO(GoodsDTO goodsDTO, @MappingTarget Goods goods);

}
