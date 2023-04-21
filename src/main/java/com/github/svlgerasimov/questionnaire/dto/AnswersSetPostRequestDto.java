package com.github.svlgerasimov.questionnaire.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "Data for posting new answer set")
public record AnswersSetPostRequestDto(@NotNull List<AnswerBatchPostRequestDto> answers) {
}
