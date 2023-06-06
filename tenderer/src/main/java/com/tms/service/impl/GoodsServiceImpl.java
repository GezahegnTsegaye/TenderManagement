package com.tms.service.impl;


import com.tms.dal.dto.GoodsDTO;
import com.tms.dal.mapper.GoodsMapper;
import com.tms.dal.models.Goods;
import com.tms.dal.repository.GoodsRepository;
import com.tms.exception.EntityNotFoundException;
import com.tms.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GoodsServiceImpl implements GoodsService {


  private final GoodsRepository goodsRepository;
  private final GoodsMapper goodsMapper;


  @Override
  public List<GoodsDTO> getAllGoods() {
    List<Goods> goodsList = goodsRepository.findAll();
    return goodsMapper.toDTOList(goodsList);
  }

  @Override
  public GoodsDTO getGoodsById(Long goodsId) {
    Goods goods = goodsRepository.findById(goodsId)
            .orElseThrow(() -> new EntityNotFoundException("Goods not found with ID: " + goodsId));
    return goodsMapper.toDTO(goods);
  }

//  public GoodsDTO getGoodsById(Long goodsId) {
//    Goods goods = goodsRepository.findById(goodsId)
//            .orElseThrow(() -> new NotFoundException("Goods not found with ID: " + goodsId));
//    GoodsDTO goodsDTO = goodsMapper.toDTO(goods);
//    List<ReviewDTO> reviews = reviewService.getReviewsByGoodsId(goodsId);
//    goodsDTO.setReviews(reviews);
//    return goodsDTO;
//  }

  @Override
  public GoodsDTO createGoods(GoodsDTO goodsDTO) {
    Goods goods = goodsMapper.toEntity(goodsDTO);
    goods.setCreatedDate(LocalDateTime.now());
    Goods savedGoods = goodsRepository.save(goods);
    return goodsMapper.toDTO(savedGoods);
  }

  @Override
  public GoodsDTO updateGoods(Long goodsId, GoodsDTO goodsDTO) {
    Goods existingGoods = goodsRepository.findById(goodsId)
            .orElseThrow(() -> new EntityNotFoundException("Goods not found with ID: " + goodsId));

    Goods updatedGoods = goodsMapper.updateFromDTO(goodsDTO, existingGoods);
    updatedGoods.setLastModifiedDate(LocalDateTime.now());

    Goods savedGoods = goodsRepository.save(updatedGoods);
    return goodsMapper.toDTO(savedGoods);
  }

  @Override
  public void deleteGoods(Long goodsId) {
    Goods goods = goodsRepository.findById(goodsId)
            .orElseThrow(() -> new EntityNotFoundException("Goods not found with ID: " + goodsId));
    goodsRepository.delete(goods);
  }


}
