package com.code.exercise.demo.repository;

import com.code.exercise.demo.entity.PostCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategoryEntity, Long> {
}
