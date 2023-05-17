package com.tms.controller;

import com.tms.dal.dto.GoodsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface GoodsController {
  @GetMapping
  ResponseEntity<List<GoodsDTO>> getAllGoods();

  @GetMapping("/{goodsId}")
  ResponseEntity<GoodsDTO> getGoodsById(@PathVariable Long goodsId);

  @PostMapping
  ResponseEntity<GoodsDTO> createGoods(@RequestBody GoodsDTO goodsDTO);

  @PutMapping("/{goodsId}")
  ResponseEntity<GoodsDTO> updateGoods(@PathVariable Long goodsId, @RequestBody GoodsDTO goodsDTO);
}
