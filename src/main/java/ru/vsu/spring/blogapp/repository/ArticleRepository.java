package ru.vsu.spring.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.vsu.spring.blogapp.domain.entity.ArticleEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

//    List<ArticleEntity> findAll();
//
//    Optional<ArticleEntity> findById(final Long id);

    Optional<ArticleEntity> findByTitle(final String title);

    Optional<List<ArticleEntity>> findAllByPublishDate(final LocalDate date);

   // List<ArticleEntity> findAllByAuthorId(final Long authorId);

    @Modifying
    @Query("DELETE FROM ArticleEntity WHERE id = :id")
    void delete(final Long id);

}
