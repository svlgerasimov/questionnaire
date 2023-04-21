package com.github.svlgerasimov.questionnaire.service.impl;

import com.github.svlgerasimov.questionnaire.accessor.AnswerAccessor;
import com.github.svlgerasimov.questionnaire.accessor.AnswersSetAccessor;
import com.github.svlgerasimov.questionnaire.accessor.FormAccessor;
import com.github.svlgerasimov.questionnaire.accessor.QuestionAccessor;
import com.github.svlgerasimov.questionnaire.dto.AnswerBatchPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.AnswersSetPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.AnswersSetResponseDto;
import com.github.svlgerasimov.questionnaire.exception.ConditionsNotMetException;
import com.github.svlgerasimov.questionnaire.mapper.AnswerMapper;
import com.github.svlgerasimov.questionnaire.mapper.AnswersSetMapper;
import com.github.svlgerasimov.questionnaire.model.AnswerEntity;
import com.github.svlgerasimov.questionnaire.model.AnswersSetEntity;
import com.github.svlgerasimov.questionnaire.model.FormEntity;
import com.github.svlgerasimov.questionnaire.model.QuestionEntity;
import com.github.svlgerasimov.questionnaire.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Transactional(readOnly = true)
public class AnswerServiceImpl implements AnswerService {

    private final AnswerAccessor answerAccessor;
    private final AnswersSetAccessor answersSetAccessor;
    private final FormAccessor formAccessor;
    private final QuestionAccessor questionAccessor;
    private final AnswersSetMapper answersSetMapper;
    private final AnswerMapper answerMapper;

    @Transactional
    @Override
    public AnswersSetResponseDto add(AnswersSetPostRequestDto answersSetPostRequestDto, Long formId) {
        FormEntity formEntity = formAccessor.findById(formId);
        AnswersSetEntity answersSetEntity = new AnswersSetEntity();
        answersSetEntity.setForm(formEntity);
        AnswersSetEntity savedAnswersSetEntity = answersSetAccessor.save(answersSetEntity);
        List<AnswerBatchPostRequestDto> answerDtos = answersSetPostRequestDto.answers();
        List<Long> questionIds = answerDtos.stream()
                .map(AnswerBatchPostRequestDto::questionId)
                .distinct()
                .toList();
        if (questionIds.size() < answerDtos.size()) {
            throw new ConditionsNotMetException("Only one answer per question is allowed");
        }
        List<QuestionEntity> questionEntities = questionAccessor.findAllByIdIn(questionIds);
        if (questionEntities.size() < questionIds.size()) {
            throw new ConditionsNotMetException("Not all the questions exist");
        }
        questionEntities.forEach(question -> {
            Long id = question.getForm().getId();
            if (!Objects.equals(id, formId)) {
                throw new ConditionsNotMetException("Question with id=" + question.getId() +
                        " does not belong to form with id=" + formId);
            }
        });
        Map<Long, QuestionEntity> questionById = questionEntities.stream()
                .collect(Collectors.toMap(QuestionEntity::getId, Function.identity()));
        List<AnswerEntity> answerEntities = answerDtos.stream()
                .map(answer -> answerMapper.fromDto(
                        answer,
                        questionById.get(answer.questionId()),
                        savedAnswersSetEntity
                ))
                .toList();
        answerEntities = answerAccessor.saveAll(answerEntities);
        return answersSetMapper.toDto(savedAnswersSetEntity, answerEntities);
    }

    @Override
    public List<AnswersSetResponseDto> findAll(Long formId) {
        List<AnswersSetEntity> answersSetEntities = answersSetAccessor.findAllByFormId(formId);
        List<Long> answersSetIds = answersSetEntities.stream().map(AnswersSetEntity::getId).toList();
        List<AnswerEntity> answerEntities = answerAccessor.findAllByAnswersSetIdIn(answersSetIds);
        Map<Long, List<AnswerEntity>> answersByAnswersSetIds = answerEntities.stream()
                .collect(Collectors.groupingBy(answer -> answer.getAnswersSet().getId()));
        return answersSetEntities.stream()
                .map(answersSetEntity ->
                        answersSetMapper.toDto(
                                answersSetEntity,
                                answersByAnswersSetIds.get(answersSetEntity.getId())
                        )
                )
                .toList();
    }
}
