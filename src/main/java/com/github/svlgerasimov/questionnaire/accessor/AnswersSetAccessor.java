package com.github.svlgerasimov.questionnaire.accessor;

import com.github.svlgerasimov.questionnaire.model.AnswersSetEntity;

import java.util.List;

public interface AnswersSetAccessor {

    AnswersSetEntity findByIdAndFormId(Long id, Long formId);

    List<AnswersSetEntity> findAllByFormId(Long formId);

    AnswersSetEntity save(AnswersSetEntity entity);
}
