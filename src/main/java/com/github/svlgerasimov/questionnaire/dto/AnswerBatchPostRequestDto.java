package com.github.svlgerasimov.questionnaire.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Answer data for adding an answer within an answer set")
public record AnswerBatchPostRequestDto(@NotBlank String text, @NotNull Long questionId) {
}
