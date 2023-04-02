package com.github.svlgerasimov.questionnaire.dto;

import java.util.List;

public record FormResponseDto(Long id, String name, List<QuestionResponseDtoEmbedded> questions) {
}
