package com.github.svlgerasimov.questionnaire.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Full data about a question, includes short data about parent form")
public record QuestionResponseDto(Long id, String text, FormResponseDtoShort form) {
}
