package com.github.svlgerasimov.questionnaire.service;

import com.github.svlgerasimov.questionnaire.dto.FormPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.FormResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface FormService {
    @Transactional
    FormResponseDto add(FormPostRequestDto postRequestDto);

    FormResponseDto findById(Long formId);
}
