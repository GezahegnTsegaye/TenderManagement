package com.tms.controller;

import com.tms.dal.dto.GoodsDTO;
import com.tms.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/goods")
public class GoodsControllerImpl implements GoodsController {


  private final GoodsService goodsService;


  @Override
  @GetMapping
  public ResponseEntity<List<GoodsDTO>> getAllGoods() {
    List<GoodsDTO> goodsList = goodsService.getAllGoods();
    return ResponseEntity.ok(goodsList);
  }

  @Override
  @GetMapping("/{goodsId}")
  public ResponseEntity<GoodsDTO> getGoodsById(@PathVariable Long goodsId) {
    GoodsDTO goods = goodsService.getGoodsById(goodsId);
    return ResponseEntity.ok(goods);
  }

  @Override
  @PostMapping
  public ResponseEntity<GoodsDTO> createGoods(@RequestBody GoodsDTO goodsDTO) {
    GoodsDTO createdGoods = goodsService.createGoods(goodsDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdGoods);
  }

  @Override
  @PutMapping("/{goodsId}")
  public ResponseEntity<GoodsDTO> updateGoods(@PathVariable Long goodsId, @RequestBody GoodsDTO goodsDTO) {
    GoodsDTO updatedGoods = goodsService.updateGoods(goodsId, goodsDTO);
    return ResponseEntity.ok(updatedGoods);
  }

  @DeleteMapping("/{goodsId}")
  public ResponseEntity<Void> deleteGoods(@PathVariable Long goodsId) {
    goodsService.deleteGoods(goodsId);
    return ResponseEntity.noContent().build();
  }

// Add more API endpoints for advanced functionalities

}
