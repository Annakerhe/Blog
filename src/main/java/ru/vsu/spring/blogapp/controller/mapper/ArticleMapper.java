package ru.vsu.spring.blogapp.controller.mapper;

import org.mapstruct.Mapper;
import ru.vsu.spring.blogapp.domain.dto.ArticleDto;
import ru.vsu.spring.blogapp.domain.entity.Article;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleDto toDto(Article article);

    List<ArticleDto> toDto(List<Article> article);

    Article toEntity(ArticleDto dto);
}
