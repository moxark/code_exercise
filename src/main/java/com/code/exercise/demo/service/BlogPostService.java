package com.code.exercise.demo.service;

import com.code.exercise.demo.dto.BlogPostCreationDto;
import com.code.exercise.demo.dto.BlogPostDto;
import com.code.exercise.demo.entity.BlogPostEntity;
import com.code.exercise.demo.entity.PostCategoryEntity;
import com.code.exercise.demo.mapper.BlogPostMapper;
import com.code.exercise.demo.repository.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;


    public BlogPostDto getBlogPost(Long id) {
        return blogPostRepository.findById(id).map(BlogPostMapper.MAPPER::entityToDto).orElse(null);
    }

    public List<BlogPostDto> getAllBlogPost(){
        List<BlogPostEntity> blogPosts = blogPostRepository.findAllOrderByTimestampDesc();
        List<BlogPostDto> blogPostDtos = new ArrayList<>(blogPosts.size());
        blogPosts.forEach(blogPostEntity -> blogPostDtos.add(BlogPostMapper.MAPPER.entityToDto(blogPostEntity)));
        return blogPostDtos;
    }


    public BlogPostDto createBlogPost(BlogPostCreationDto blogPostCreationDto) {
        BlogPostEntity blogPostEntity = BlogPostEntity.builder()
                .title(blogPostCreationDto.getTitle())
                .contents(blogPostCreationDto.getContents())
                .build();
        blogPostEntity.setCategory(PostCategoryEntity.getById(blogPostCreationDto.getCategoryId()));

        blogPostEntity = blogPostRepository.save(blogPostEntity);

        return BlogPostDto.builder()
                .id(blogPostEntity.getId())
                .title(blogPostEntity.getTitle())
                .categoryId(blogPostEntity.getCategory().getId())
                .contents(blogPostEntity.getContents())
                .timestamp(blogPostEntity.getCreated_at())
                .build();
    }

    public void deleteBlogPost(Long id){
        blogPostRepository.deleteById(id);
    }

    public void deleteAllBlogPost(){
        blogPostRepository.deleteAll();
    }


}
