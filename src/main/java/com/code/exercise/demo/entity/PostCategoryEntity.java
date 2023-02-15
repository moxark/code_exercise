package com.code.exercise.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_category")
@Getter
public enum PostCategoryEntity {

    GENERAL(1L, "General"),
    TECHNOLOGY(2L, "Technology"),
    RANDOM(3L, "Random");

    @Id
    private Long id;

    private String name;

    public static PostCategoryEntity getById(Long id) {
        for(PostCategoryEntity category : values()){
            if(Objects.equals(category.id, id)){
                return category;
            }
        }
        return PostCategoryEntity.RANDOM;
    }

}
