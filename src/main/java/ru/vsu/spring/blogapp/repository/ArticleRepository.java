package ru.vsu.spring.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.vsu.spring.blogapp.domain.entity.Article;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findByTitle(final String title);

    Optional<List<Article>> findAllByPublishDate(final LocalDate date);

    @Modifying
    @Query("DELETE FROM Article WHERE id = :id")
    void delete(final Long id);

}
