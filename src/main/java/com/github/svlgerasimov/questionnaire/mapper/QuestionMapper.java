package com.github.svlgerasimov.questionnaire.mapper;

import com.github.svlgerasimov.questionnaire.dto.QuestionPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.QuestionResponseDto;
import com.github.svlgerasimov.questionnaire.model.QuestionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = FormShortMapper.class)
public interface QuestionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "form", ignore = true)
    QuestionEntity fromDto(QuestionPostRequestDto postRequestDto);

    QuestionResponseDto toDto(QuestionEntity entity);
}
