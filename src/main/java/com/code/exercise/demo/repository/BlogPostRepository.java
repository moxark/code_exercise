package com.code.exercise.demo.repository;

import com.code.exercise.demo.entity.BlogPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPostEntity, Long> {

    @Query("SELECT bpe FROM BlogPostEntity bpe order by timestamp desc")
    public List<BlogPostEntity> findAllOrderByTimestampDesc();
}
