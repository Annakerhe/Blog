package ru.vsu.spring.blogapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vsu.spring.blogapp.controller.mapper.CommentMapper;
import ru.vsu.spring.blogapp.domain.dto.CommentDto;
import ru.vsu.spring.blogapp.domain.entity.Comment;
import ru.vsu.spring.blogapp.service.CommentService;

import java.util.List;
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/{articleId}/comment/")
public class CommentController {
    private CommentService commentService;
    private CommentMapper commentMapper;
    @GetMapping("/")
    public List<CommentDto> getAllArticles(@PathVariable Long articleId) {
       return commentMapper.toDto(commentService.getAllByArticleId(articleId));
    }
    @GetMapping("/{authorId}")
    public List<CommentDto> getAllCommentsByArticleIdAndAuthorId(@PathVariable Long articleId, @PathVariable Long authorId) {
        return commentMapper.toDto(commentService.findAllByArticleIdAndAuthorId (articleId, authorId));
    }

    @PostMapping("/add")
    public CommentDto addComment(@RequestBody CommentDto commentDto) {
        Comment comment = commentMapper.toEntity(commentDto);
        Comment createdComment = commentService.create(comment);
        return commentMapper.toDto(createdComment);
    }

    @PutMapping("/update")
    public CommentDto updateComment(@RequestBody CommentDto commentDto) {
        Comment comment = commentMapper.toEntity(commentDto);
        Comment updatedComment = commentService.update(comment);
        return commentMapper.toDto(updatedComment);
    }
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }
}
