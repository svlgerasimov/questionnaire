package com.github.svlgerasimov.questionnaire.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Answer data for being embedded to answer set data")
public record AnswerResponseDtoEmbedded(Long id, String text, QuestionResponseDtoEmbedded question) {
}
