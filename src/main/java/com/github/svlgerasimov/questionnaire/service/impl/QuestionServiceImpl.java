package com.github.svlgerasimov.questionnaire.service.impl;

import com.github.svlgerasimov.questionnaire.accessor.FormAccessor;
import com.github.svlgerasimov.questionnaire.accessor.QuestionAccessor;
import com.github.svlgerasimov.questionnaire.dto.QuestionPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.QuestionResponseDto;
import com.github.svlgerasimov.questionnaire.mapper.QuestionMapper;
import com.github.svlgerasimov.questionnaire.model.FormEntity;
import com.github.svlgerasimov.questionnaire.model.QuestionEntity;
import com.github.svlgerasimov.questionnaire.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Transactional(readOnly = true)
public class QuestionServiceImpl implements QuestionService {

    private final QuestionAccessor questionAccessor;
    private final FormAccessor formAccessor;
    private final QuestionMapper questionMapper;

    @Override
    @Transactional
    public QuestionResponseDto add(QuestionPostRequestDto postRequestDto,
                                   Long formId) {
        FormEntity formEntity = formAccessor.findById(formId);
        QuestionEntity questionEntity = questionMapper.fromDto(postRequestDto);
        questionEntity.setForm(formEntity);
        questionEntity = questionAccessor.save(questionEntity);
        log.debug("Add question: {} to form {}", questionEntity, formEntity);
        return questionMapper.toDto(questionEntity);
    }

    @Override
    public QuestionResponseDto findById(Long questionId, Long formId) {
        return questionMapper.toDto(questionAccessor.findById(questionId, formId));
    }
}
