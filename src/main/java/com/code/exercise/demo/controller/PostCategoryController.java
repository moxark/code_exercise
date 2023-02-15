package com.code.exercise.demo.controller;

import com.code.exercise.demo.entity.PostCategoryEntity;
import com.code.exercise.demo.service.PostCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Slf4j
public class PostCategoryController {

    private final PostCategoryService postCategoryService;


    @GetMapping("")
    public List<PostCategoryEntity> getPostCategories(){
        return postCategoryService.getAllPostCategories();
    }


}
