package ru.vsu.spring.blogapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vsu.spring.blogapp.domain.entity.CommentEntity;
import ru.vsu.spring.blogapp.service.CommentService;

import java.util.List;
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/blog/comment/{articleId}")
public class CommentController {
    private CommentService commentService;
    @GetMapping("/")
    public List<CommentEntity> getAllArticles(@PathVariable Long articleId) {
       return commentService.getAllByArticleId(articleId);

    }
    @GetMapping("/{authorId}")
    public List<CommentEntity> getAllCommentsByAuthorId(@PathVariable Long articleId, @PathVariable Long authorId) {
        List<CommentEntity> comments = commentService.findAllByArticleIdAndAuthorId (articleId, authorId);
        return comments;// toDTO
    }


    @PostMapping("/add")
    public CommentEntity addComment(@RequestBody CommentEntity comment) {
        return commentService.create(comment);
    }

    @PutMapping("/update")
    public CommentEntity updateComment(@RequestBody CommentEntity comment) {
        return  commentService.update(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }
}
