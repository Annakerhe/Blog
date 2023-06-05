package ru.vsu.spring.blogapp.domain.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.vsu.spring.blogapp.domain.dto.ArticleDto;
import ru.vsu.spring.blogapp.domain.entity.ArticleEntity;
import ru.vsu.spring.blogapp.domain.entity.AuthorEntity;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ArticleMapper {
    ArticleDto toDto(ArticleEntity article);

    List<ArticleDto> toDto(List<ArticleEntity> article);

    ArticleEntity toEntity(ArticleDto dto);
}
