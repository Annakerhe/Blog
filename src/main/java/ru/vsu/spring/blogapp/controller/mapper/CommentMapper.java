package ru.vsu.spring.blogapp.controller.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.vsu.spring.blogapp.domain.dto.CommentDto;
import ru.vsu.spring.blogapp.domain.entity.CommentEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto toDto(CommentEntity comment);

    List<CommentDto> toDto(List<CommentEntity> comments);

    CommentEntity toEntity(CommentDto dto);
}
