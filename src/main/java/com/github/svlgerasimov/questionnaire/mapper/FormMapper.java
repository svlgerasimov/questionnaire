package com.github.svlgerasimov.questionnaire.mapper;

import com.github.svlgerasimov.questionnaire.dto.FormPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.FormResponseDto;
import com.github.svlgerasimov.questionnaire.model.FormEntity;
import com.github.svlgerasimov.questionnaire.model.QuestionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = QuestionEmbeddedMapper.class)
public interface FormMapper {

    @Mapping(target = "id", ignore = true)
    FormEntity fromDto(FormPostRequestDto postRequestDto);

    @Mapping(target = "questions", source = "questionEntities")
    FormResponseDto toDto(FormEntity formEntity, List<QuestionEntity> questionEntities);
}
