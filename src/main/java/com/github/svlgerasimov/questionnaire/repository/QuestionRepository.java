package com.github.svlgerasimov.questionnaire.repository;

import com.github.svlgerasimov.questionnaire.model.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

    @Query("select q from QuestionEntity q where q.form.id=:formId")
    List<QuestionEntity> findAllByFormId(@Param("formId") Long formId);

    @Query("select q from QuestionEntity q where q.id in :ids")
    List<QuestionEntity> finsAllByIdIn(@Param("ids") List<Long> ids);

    @Query("select q from QuestionEntity q join fetch q.form where q.id=:id and q.form.id=:formId")
    Optional<QuestionEntity> findByIdAndFormId(Long id, Long formId);
}
