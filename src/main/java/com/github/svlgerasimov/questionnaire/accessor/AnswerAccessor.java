package com.github.svlgerasimov.questionnaire.accessor;

import com.github.svlgerasimov.questionnaire.model.AnswerEntity;

import java.util.List;

public interface AnswerAccessor {
    List<AnswerEntity> findAllByAnswersSetId(Long answersSetId);

    List<AnswerEntity> findAllByAnswersSetIdIn(List<Long> answersSetIds);

    List<AnswerEntity>  saveAll(List<AnswerEntity> entities);
}
