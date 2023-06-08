package ru.vsu.spring.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.vsu.spring.blogapp.domain.entity.ArticleEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    Optional<ArticleEntity> findByTitle(final String title);

    Optional<List<ArticleEntity>> findAllByPublishDate(final LocalDate date);

    @Modifying
    @Query("DELETE FROM ArticleEntity WHERE id = :id")
    void delete(final Long id);

}
