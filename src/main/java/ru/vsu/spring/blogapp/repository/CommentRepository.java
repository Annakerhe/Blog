package ru.vsu.spring.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.vsu.spring.blogapp.domain.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findAllByArticleId(final Long articleId);

    Optional<List<Comment>> findAllByArticleIdAndAuthorId(final Long articleId, final Long authorId);

    Optional<Comment> findByBody(final String body);


    @Modifying
    @Query("DELETE FROM Comment WHERE id = :id")
    void delete(Long id);
}
