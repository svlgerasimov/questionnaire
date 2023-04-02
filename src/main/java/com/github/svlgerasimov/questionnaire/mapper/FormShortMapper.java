package com.github.svlgerasimov.questionnaire.mapper;

import com.github.svlgerasimov.questionnaire.dto.FormResponseDtoShort;
import com.github.svlgerasimov.questionnaire.model.FormEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FormShortMapper {

    FormResponseDtoShort toDtoShort(FormEntity entity);
}
