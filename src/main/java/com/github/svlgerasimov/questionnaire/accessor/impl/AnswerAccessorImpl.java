package com.github.svlgerasimov.questionnaire.accessor.impl;

import com.github.svlgerasimov.questionnaire.accessor.AnswerAccessor;
import com.github.svlgerasimov.questionnaire.model.AnswerEntity;
import com.github.svlgerasimov.questionnaire.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AnswerAccessorImpl implements AnswerAccessor {

    private final AnswerRepository answerRepository;

    @Override
    public List<AnswerEntity> findAllByAnswersSetId(Long answersSetId) {
        return answerRepository.findAllByAnswersSetId(answersSetId);
    }

    @Override
    public List<AnswerEntity> findAllByAnswersSetIdIn(List<Long> answersSetIds) {
        return answerRepository.findAllByAnswersSetIdIn(answersSetIds);
    }

    @Override
    public List<AnswerEntity>  saveAll(List<AnswerEntity> entities) {
        return answerRepository.saveAll(entities);
    }
}
