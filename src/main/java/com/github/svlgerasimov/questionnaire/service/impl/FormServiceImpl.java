package com.github.svlgerasimov.questionnaire.service.impl;

import com.github.svlgerasimov.questionnaire.accessor.FormAccessor;
import com.github.svlgerasimov.questionnaire.accessor.QuestionAccessor;
import com.github.svlgerasimov.questionnaire.dto.FormPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.FormResponseDto;
import com.github.svlgerasimov.questionnaire.mapper.FormMapper;
import com.github.svlgerasimov.questionnaire.model.FormEntity;
import com.github.svlgerasimov.questionnaire.model.QuestionEntity;
import com.github.svlgerasimov.questionnaire.service.FormService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Transactional(readOnly = true)
public class FormServiceImpl implements FormService {

    private final FormAccessor formAccessor;
    private final QuestionAccessor questionAccessor;
    private final FormMapper formMapper;

    @Override
    @Transactional
    public FormResponseDto add(FormPostRequestDto postRequestDto) {
        FormEntity formEntity = formMapper.fromDto(postRequestDto);
        formEntity = formAccessor.save(formEntity);
        log.debug("Add form: {}", formEntity);
        return formMapper.toDto(formEntity, Collections.emptyList());
    }

    @Override
    public FormResponseDto findById(Long formId) {
        FormEntity formEntity = formAccessor.findById(formId);
        List<QuestionEntity> questionEntities = questionAccessor.findAllByFormId(formId);
        return formMapper.toDto(formEntity, questionEntities);
    }

}
