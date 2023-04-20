package com.github.svlgerasimov.questionnaire.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Short data about a question for being embedded to form data")
public record QuestionResponseDtoEmbedded(Long id, String text) {
}
