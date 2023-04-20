package com.github.svlgerasimov.questionnaire.repository;

import com.github.svlgerasimov.questionnaire.model.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {

    @Query("select a from AnswerEntity a join fetch a.question where a.answersSet.id=:answersSetId")
    List<AnswerEntity> findAllByAnswersSetId(@Param("answersSetId") Long answersSetId);

    @Query("select a from AnswerEntity a join fetch a.question q where a.answersSet.id in :answersSetIds")
    List<AnswerEntity> findAllByAnswersSetIdIn(@Param("answersSetIds") List<Long> answersSetIds);
}
