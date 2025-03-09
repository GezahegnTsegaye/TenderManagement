package com.egov.tendering.evaluation.dal.mapper;

import com.egov.tendering.evaluation.dal.dto.CommitteeReviewDTO;
import com.egov.tendering.evaluation.dal.model.CommitteeReview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * MapStruct mapper for converting between CommitteeReview entity and DTO
 */
@Mapper(componentModel = "spring")
public interface CommitteeReviewMapper {

    /**
     * Maps CommitteeReview entity to CommitteeReviewDTO
     *
     * @param review the entity to map
     * @return the mapped DTO
     */
    CommitteeReviewDTO toDto(CommitteeReview review);

    /**
     * Maps CommitteeReviewDTO to CommitteeReview entity
     *
     * @param dto the DTO to map
     * @return the mapped entity
     */
    CommitteeReview toEntity(CommitteeReviewDTO dto);

    /**
     * Maps a list of CommitteeReview entities to DTOs
     *
     * @param reviews the list of entities to map
     * @return the list of mapped DTOs
     */
    List<CommitteeReviewDTO> toDtoList(List<CommitteeReview> reviews);

    /**
     * Maps a list of CommitteeReviewDTOs to entities
     *
     * @param dtos the list of DTOs to map
     * @return the list of mapped entities
     */
    List<CommitteeReview> toEntityList(List<CommitteeReviewDTO> dtos);
}