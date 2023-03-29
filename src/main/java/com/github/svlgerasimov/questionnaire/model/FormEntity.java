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
@Table(name = "forms")
public class FormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormEntity formEntity = (FormEntity) o;
        return Objects.nonNull(id) && id.equals(formEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
