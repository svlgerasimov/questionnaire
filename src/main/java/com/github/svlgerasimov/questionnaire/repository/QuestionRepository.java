package com.github.svlgerasimov.questionnaire.repository;

import com.github.svlgerasimov.questionnaire.model.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
}
