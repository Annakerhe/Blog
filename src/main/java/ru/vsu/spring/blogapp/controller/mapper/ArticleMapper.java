package ru.vsu.spring.blogapp.controller.mapper;

import org.mapstruct.Mapper;
import ru.vsu.spring.blogapp.domain.dto.ArticleDto;
import ru.vsu.spring.blogapp.domain.entity.ArticleEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleDto toDto(ArticleEntity article);

    List<ArticleDto> toDto(List<ArticleEntity> article);

    ArticleEntity toEntity(ArticleDto dto);
}
