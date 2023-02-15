package com.code.exercise.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostDto {

    private Long id;

    private String title;

    private String contents;

    private Long categoryId;

    private LocalDateTime timestamp;

}
