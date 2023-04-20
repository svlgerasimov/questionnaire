package com.github.svlgerasimov.questionnaire.accessor.impl;

import com.github.svlgerasimov.questionnaire.accessor.AnswersSetAccessor;
import com.github.svlgerasimov.questionnaire.exception.NotFoundException;
import com.github.svlgerasimov.questionnaire.model.AnswersSetEntity;
import com.github.svlgerasimov.questionnaire.repository.AnswersSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AnswersSetAccessorImpl implements AnswersSetAccessor {

    private final AnswersSetRepository answersSetRepository;

    @Override
    public AnswersSetEntity findByIdAndFormId(Long id, Long formId) {
        return answersSetRepository.findByIdAndFormId(id, formId).orElseThrow(
                () -> new NotFoundException("Answers set with id=" + id + " not found")
        );
    }

    @Override
    public List<AnswersSetEntity> findAllByFormId(Long formId) {
        return answersSetRepository.findAllByFormId(formId);
    }

    @Override
    public AnswersSetEntity save(AnswersSetEntity entity) {
        return answersSetRepository.save(entity);
    }
}
