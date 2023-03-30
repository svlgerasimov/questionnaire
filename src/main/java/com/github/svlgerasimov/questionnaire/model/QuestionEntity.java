package com.github.svlgerasimov.questionnaire.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "questions")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id")
    @ToString.Exclude
    private FormEntity form;

    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity questionEntity = (QuestionEntity) o;
        return Objects.nonNull(id) && id.equals(questionEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
