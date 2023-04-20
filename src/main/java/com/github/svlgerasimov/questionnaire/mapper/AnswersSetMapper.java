package com.github.svlgerasimov.questionnaire.mapper;

import com.github.svlgerasimov.questionnaire.dto.AnswersSetPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.AnswersSetResponseDto;
import com.github.svlgerasimov.questionnaire.model.AnswerEntity;
import com.github.svlgerasimov.questionnaire.model.AnswersSetEntity;
import com.github.svlgerasimov.questionnaire.model.FormEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = FormShortMapper.class)
public interface AnswersSetMapper {

    @Mapping(target = "id", ignore = true)
    AnswersSetEntity fromDto(AnswersSetPostRequestDto dto, FormEntity form);

    AnswersSetResponseDto toDto(AnswerEntity entity, List<AnswerEntity> answers);
}
