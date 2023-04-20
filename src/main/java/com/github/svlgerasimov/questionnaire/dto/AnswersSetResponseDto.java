package com.github.svlgerasimov.questionnaire.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Answer set data, includes short data about form and list of answers")
public record AnswersSetResponseDto(Long id, FormResponseDtoShort form, List<AnswerResponseDtoEmbedded> answers) {
}
