package com.code.exercise.demo.mapper;

import com.code.exercise.demo.dto.BlogPostCreationDto;
import com.code.exercise.demo.dto.BlogPostDto;
import com.code.exercise.demo.entity.BlogPostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface BlogPostMapper extends Converter<BlogPostEntity, BlogPostDto> {

    BlogPostMapper MAPPER = Mappers.getMapper(BlogPostMapper.class);

    BlogPostEntity dtoToEntity(BlogPostDto blogPostDto);

    @Mapping(source = "category.id", target = "categoryId")
    BlogPostDto entityToDto(BlogPostEntity blogPostEntity);

    //@Mapping(target = "category", ignore = true)
    BlogPostEntity creationDtoToEntity(BlogPostCreationDto blogPostCreationDto);

}
