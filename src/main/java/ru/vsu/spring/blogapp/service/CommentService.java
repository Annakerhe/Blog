package ru.vsu.spring.blogapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.spring.blogapp.domain.entity.CommentEntity;
import ru.vsu.spring.blogapp.domain.exception.ResourceNotFoundException;
import ru.vsu.spring.blogapp.repository.CommentRepository;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<CommentEntity> getAllByArticleId(Long articleId) {
        return commentRepository.findAllByArticleId(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Comments not found"));
    }

    @Transactional(readOnly = true)
    public CommentEntity getByBody(String body) {
        return commentRepository.findByBody(body)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
    }

    @Transactional
    public CommentEntity update(CommentEntity comment) {
        commentRepository.save(comment);
        return comment;
    }

    @Transactional
    public CommentEntity create(CommentEntity comment) {
        comment.setPublishDate(LocalDate.now());
        commentRepository.save(comment);
        return comment;
    }

    @Transactional
    public void delete(Long id) {
        commentRepository.delete(id);
    }
    @Transactional(readOnly = true)
    public List<CommentEntity> findAllByArticleIdAndAuthorId(Long articleId, Long authorId) {
        return commentRepository.findAllByArticleIdAndAuthorId(articleId,authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Comments not found"));
    }
}