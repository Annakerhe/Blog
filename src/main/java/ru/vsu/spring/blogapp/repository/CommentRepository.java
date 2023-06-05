package ru.vsu.spring.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.vsu.spring.blogapp.domain.entity.CommentEntity;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    Optional<List<CommentEntity>> findAllByArticleId(final Long articleId);

    Optional<List<CommentEntity>> findAllByArticleIdAndAuthorId(final Long articleId, final Long authorId);

    Optional<CommentEntity> findByBody(final String body);


    @Modifying
    @Query("DELETE FROM CommentEntity WHERE id = :id")
    void delete(Long id);
}
