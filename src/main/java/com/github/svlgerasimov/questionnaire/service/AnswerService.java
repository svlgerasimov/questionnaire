package com.github.svlgerasimov.questionnaire.service;

import com.github.svlgerasimov.questionnaire.dto.AnswersSetPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.AnswersSetResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnswerService {
    @Transactional
    AnswersSetResponseDto add(AnswersSetPostRequestDto answersSetPostRequestDto, Long formId);

    List<AnswersSetResponseDto> findAll(Long formId);
}
