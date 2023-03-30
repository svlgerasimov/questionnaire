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
@Table(name = "answers_sets")
public class AnswersSetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id")
    @ToString.Exclude
    private FormEntity form;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswersSetEntity answersSetEntity = (AnswersSetEntity) o;
        return Objects.nonNull(id) && id.equals(answersSetEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
