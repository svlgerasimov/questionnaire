package com.github.svlgerasimov.questionnaire.accessor;

import com.github.svlgerasimov.questionnaire.model.QuestionEntity;

import java.util.List;

public interface QuestionAccessor {
    QuestionEntity findById(Long id);

    QuestionEntity findById(Long id, Long formId);

    List<QuestionEntity> findAllByFormId(Long formId);

    QuestionEntity save(QuestionEntity entity);
}
