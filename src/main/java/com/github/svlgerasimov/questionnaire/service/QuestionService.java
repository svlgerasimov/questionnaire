package com.github.svlgerasimov.questionnaire.service;

import com.github.svlgerasimov.questionnaire.dto.QuestionPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.QuestionResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface QuestionService {
    @Transactional
    QuestionResponseDto add(QuestionPostRequestDto postRequestDto,
                            Long formId);

    QuestionResponseDto findById(Long questionId, Long formId);
}
