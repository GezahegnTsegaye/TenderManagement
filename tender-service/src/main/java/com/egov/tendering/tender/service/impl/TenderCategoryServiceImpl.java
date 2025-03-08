package com.egov.tendering.tender.service.impl;


import com.egov.tendering.tender.dal.dto.TenderCriteriaDTO;
import com.egov.tendering.tender.dal.mapper.TenderCategoryMapper;
import com.egov.tendering.tender.dal.model.TenderCategory;
import com.egov.tendering.tender.dal.repository.TenderCategoryRepository;
import com.egov.tendering.tender.service.TenderCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TenderCategoryServiceImpl implements TenderCategoryService {

    private final TenderCategoryRepository tenderCategoryRepository;
    private final TenderCategoryMapper tenderCategoryMapper;

    @Override
    public TenderCriteriaDTO createCategory(TenderCriteriaDTO categoryDTO) {
        TenderCategory category = tenderCategoryMapper.toEntity(categoryDTO);
        category = tenderCategoryRepository.save(category);
        return tenderCategoryMapper.toDTO(category);
    }

    @Override
    public TenderCriteriaDTO getCategoryById(Long id) {
        Optional<TenderCategory> category = tenderCategoryRepository.findById(id);
        return category.map(tenderCategoryMapper::toDTO).orElse(null);
    }

    @Override
    public List<TenderCriteriaDTO> getAllCategories() {
        List<TenderCategory> categories = tenderCategoryRepository.findAll();
        return tenderCategoryMapper.toDtoList(categories);
    }

    @Override
    public TenderCriteriaDTO updateCategory(Long id, TenderCriteriaDTO categoryDTO) {
        if (!tenderCategoryRepository.existsById(id)) {
            return null;
        }

        TenderCategory category = tenderCategoryMapper.toEntity(categoryDTO);
        category.setId(id);
        category = tenderCategoryRepository.save(category);
        return tenderCategoryMapper.toDTO(category);
    }

    @Override
    public void deleteCategory(Long id) {
        tenderCategoryRepository.deleteById(id);
    }

    @Override
    public List<TenderCriteriaDTO> findActiveCategories() {
        List<TenderCategory> categories = tenderCategoryRepository.findByActiveTrue();
        return tenderCategoryMapper.toDtoList(categories);
    }
}