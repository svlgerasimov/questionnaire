package com.github.svlgerasimov.questionnaire.repository;

import com.github.svlgerasimov.questionnaire.model.FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<FormEntity, Long> {
}
