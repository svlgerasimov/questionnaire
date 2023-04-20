package com.github.svlgerasimov.questionnaire.mapper;

import com.github.svlgerasimov.questionnaire.dto.AnswerBatchPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.AnswerResponseDtoEmbedded;
import com.github.svlgerasimov.questionnaire.model.AnswerEntity;
import com.github.svlgerasimov.questionnaire.model.AnswersSetEntity;
import com.github.svlgerasimov.questionnaire.model.QuestionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = QuestionEmbeddedMapper.class)
public interface AnswerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "text", source = "dto.text")
    AnswerEntity fromDto(AnswerBatchPostRequestDto dto, QuestionEntity question, AnswersSetEntity answersSet);

    AnswerResponseDtoEmbedded toDtoEmbedded(AnswerEntity entity);
}
