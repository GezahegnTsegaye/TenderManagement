package com.tms.service;

import com.tms.dal.dto.GoodsDTO;

import java.util.List;

public interface GoodsService {
  List<GoodsDTO> getAllGoods();

  GoodsDTO getGoodsById(Long goodsId);

  GoodsDTO createGoods(GoodsDTO goodsDTO);

  GoodsDTO updateGoods(Long goodsId, GoodsDTO goodsDTO);

  void deleteGoods(Long goodsId);
}
