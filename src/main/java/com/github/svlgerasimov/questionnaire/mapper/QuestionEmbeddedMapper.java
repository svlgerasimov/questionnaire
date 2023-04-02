package com.github.svlgerasimov.questionnaire.mapper;

import com.github.svlgerasimov.questionnaire.dto.QuestionResponseDtoEmbedded;
import com.github.svlgerasimov.questionnaire.model.QuestionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionEmbeddedMapper {

    QuestionResponseDtoEmbedded toDtoEmbedded(QuestionEntity entity);
}
