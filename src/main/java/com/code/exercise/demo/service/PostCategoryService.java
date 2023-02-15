package com.code.exercise.demo.service;

import com.code.exercise.demo.dto.PostCategoryDto;
import com.code.exercise.demo.entity.PostCategoryEntity;
import com.code.exercise.demo.repository.PostCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PostCategoryService {

    private final PostCategoryRepository postCategoryRepository;

    public List<PostCategoryEntity> getAllPostCategories(){
        return postCategoryRepository.findAll();

    }



}
