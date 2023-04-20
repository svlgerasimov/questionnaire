package com.github.svlgerasimov.questionnaire.repository;

import com.github.svlgerasimov.questionnaire.model.AnswersSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AnswersSetRepository extends JpaRepository<AnswersSetEntity, Long> {

    @Query("select a from AnswersSetEntity a join fetch a.form f where a.id=:id and f.id=:formId")
    Optional<AnswersSetEntity> findByIdAndFormId(@Param("id") Long id, @Param("formId") Long formId);

    @Query("select a from AnswersSetEntity a join fetch a.form f where f.id=:formId")
    List<AnswersSetEntity> findAllByFormId(@Param("formId") Long formId);
}
