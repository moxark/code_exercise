package com.code.exercise.demo.controller;

import com.code.exercise.demo.dto.BlogPostCreationDto;
import com.code.exercise.demo.dto.BlogPostDto;
import com.code.exercise.demo.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Slf4j
public class BlogPostController {

    private final BlogPostService blogPostService;

    @GetMapping("/{id}")
    public ResponseEntity<BlogPostDto> getBlogPost(@PathVariable Long id){
        BlogPostDto blogPostDto = blogPostService.getBlogPost(id);
        if(blogPostDto == null){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(blogPostDto);
        }
    }

    @GetMapping("")
    public List<BlogPostDto> getBlogPosts(){
        return blogPostService.getAllBlogPost();
    }

    @PostMapping("")
    public BlogPostDto createBlogPost(@RequestBody BlogPostCreationDto blogPostCreationDto) {
        return blogPostService.createBlogPost(blogPostCreationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable Long id){
        blogPostService.deleteBlogPost(id);
    }

    @DeleteMapping("")
    public void deleteAllBlogPost(){
        blogPostService.deleteAllBlogPost();
    }
}
