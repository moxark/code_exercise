package com.code.exercise.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blog_post")
public class BlogPostEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "post_category_id")
    private PostCategoryEntity category;

    @CreationTimestamp
    private LocalDateTime created_at;
}
