package ru.vsu.spring.blogapp.domain.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.vsu.spring.blogapp.domain.dto.AuthorDto;
import ru.vsu.spring.blogapp.domain.entity.AuthorEntity;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface AuthorMapper {
    AuthorDto toDto(AuthorEntity author);

    List<AuthorDto> toDto(List<AuthorEntity> author);

    AuthorEntity toEntity(AuthorDto dto);
}
