package com.github.svlgerasimov.questionnaire.accessor.impl;

import com.github.svlgerasimov.questionnaire.accessor.FormAccessor;
import com.github.svlgerasimov.questionnaire.exception.NotFoundException;
import com.github.svlgerasimov.questionnaire.model.FormEntity;
import com.github.svlgerasimov.questionnaire.repository.FormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FormAccessorImpl implements FormAccessor {

    private final FormRepository formRepository;

    @Override
    public FormEntity findById(Long id) {
        return formRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Form with id=" + id + " not found")
        );
    }

    @Override
    public FormEntity save(FormEntity entity) {
        return formRepository.save(entity);
    }
}
