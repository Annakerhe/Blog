package ru.vsu.spring.blogapp.controller.mapper;

import org.mapstruct.Mapper;
import ru.vsu.spring.blogapp.domain.dto.AuthorDto;
import ru.vsu.spring.blogapp.domain.entity.Author;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toDto(Author author);

    List<AuthorDto> toDto(List<Author> author);

    Author toEntity(AuthorDto dto);
}
