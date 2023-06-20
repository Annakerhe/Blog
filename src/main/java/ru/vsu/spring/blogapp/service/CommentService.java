package ru.vsu.spring.blogapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.spring.blogapp.domain.entity.Comment;
import ru.vsu.spring.blogapp.domain.exception.ResourceNotFoundException;
import ru.vsu.spring.blogapp.repository.CommentRepository;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;


    public List<Comment> getAllByArticleId(Long articleId) {
        return commentRepository.findAllByArticleId(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Comments not found"));
    }

    public Comment getByBody(String body) {
        return commentRepository.findByBody(body)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
    }

    @Transactional
    public Comment update(Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    @Transactional
    public Comment create(Comment comment) {
        comment.setPublishDate(LocalDate.now());
        commentRepository.save(comment);
        return comment;
    }
    public void delete(Long id) {
        commentRepository.delete(id);
    }

    public List<Comment> findAllByArticleIdAndAuthorId(Long articleId, Long authorId) {
        return commentRepository.findAllByArticleIdAndAuthorId(articleId,authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Comments not found"));
    }
}