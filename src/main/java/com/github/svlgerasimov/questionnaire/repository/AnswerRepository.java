package com.github.svlgerasimov.questionnaire.repository;

import com.github.svlgerasimov.questionnaire.model.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
}
