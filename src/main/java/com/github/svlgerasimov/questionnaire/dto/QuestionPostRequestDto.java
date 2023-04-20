package com.github.svlgerasimov.questionnaire.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Data for adding a question")
public record QuestionPostRequestDto(@NotBlank String text) {
}
