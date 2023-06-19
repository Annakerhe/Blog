package ru.vsu.spring.blogapp.controller.mapper;

import org.mapstruct.Mapper;
import ru.vsu.spring.blogapp.domain.dto.CommentDto;
import ru.vsu.spring.blogapp.domain.entity.Comment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto toDto(Comment comment);

    List<CommentDto> toDto(List<Comment> comments);

    Comment toEntity(CommentDto dto);
}
