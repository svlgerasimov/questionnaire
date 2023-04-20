package com.github.svlgerasimov.questionnaire.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Full data about a form, includes questions")
public record FormResponseDto(Long id, String name, List<QuestionResponseDtoEmbedded> questions) {
}
