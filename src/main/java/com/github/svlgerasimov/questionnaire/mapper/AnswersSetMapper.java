package com.github.svlgerasimov.questionnaire.mapper;

import com.github.svlgerasimov.questionnaire.dto.AnswersSetResponseDto;
import com.github.svlgerasimov.questionnaire.model.AnswerEntity;
import com.github.svlgerasimov.questionnaire.model.AnswersSetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = FormShortMapper.class)
public interface AnswersSetMapper {

    AnswersSetResponseDto toDto(AnswersSetEntity entity, List<AnswerEntity> answers);
}
