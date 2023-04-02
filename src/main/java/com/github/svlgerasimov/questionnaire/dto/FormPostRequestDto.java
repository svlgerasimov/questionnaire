package com.github.svlgerasimov.questionnaire.dto;

import jakarta.validation.constraints.NotBlank;

public record FormPostRequestDto(@NotBlank String name) {
}
