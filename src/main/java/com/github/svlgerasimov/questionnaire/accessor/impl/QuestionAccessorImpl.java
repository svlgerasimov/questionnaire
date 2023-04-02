package com.github.svlgerasimov.questionnaire.accessor.impl;

import com.github.svlgerasimov.questionnaire.accessor.QuestionAccessor;
import com.github.svlgerasimov.questionnaire.exception.NotFoundException;
import com.github.svlgerasimov.questionnaire.model.QuestionEntity;
import com.github.svlgerasimov.questionnaire.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionAccessorImpl implements QuestionAccessor {

    private final QuestionRepository questionRepository;

    @Override
    public QuestionEntity findById(Long id) {
        return questionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Question with id=" + id + " not found")
        );
    }

    @Override
    public QuestionEntity findById(Long id, Long formId) {
        return questionRepository.findByIdAndFormId(id, formId).orElseThrow(
                () -> new NotFoundException("Question with id=" + id + " and formId=" + formId + " not found")
        );
    }

    @Override
    public List<QuestionEntity> findAllByFormId(Long formId) {
        return questionRepository.findAllByFormId(formId);
    }

    @Override
    public QuestionEntity save(QuestionEntity entity) {
        return questionRepository.save(entity);
    }
}
