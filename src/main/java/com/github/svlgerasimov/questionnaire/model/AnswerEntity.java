package com.github.svlgerasimov.questionnaire.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Setter
@Getter
@ToString
@Table(name = "answers")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    @ToString.Exclude
    private QuestionEntity question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answers_set_id")
    @ToString.Exclude
    private AnswersSetEntity answersSet;

    @Column(name = "text")
    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerEntity answerEntity = (AnswerEntity) o;
        return Objects.nonNull(id) && id.equals(answerEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
