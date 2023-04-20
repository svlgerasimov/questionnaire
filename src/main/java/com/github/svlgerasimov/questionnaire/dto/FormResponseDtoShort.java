package com.github.svlgerasimov.questionnaire.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Short data about a form, without questions")
public record FormResponseDtoShort(Long id, String name) {
}
