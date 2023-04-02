package com.github.svlgerasimov.questionnaire.accessor;

import com.github.svlgerasimov.questionnaire.model.FormEntity;

public interface FormAccessor {
    FormEntity findById(Long id);

    FormEntity save(FormEntity entity);
}
