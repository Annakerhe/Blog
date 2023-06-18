package ru.vsu.spring.blogapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.spring.blogapp.domain.entity.ArticleEntity;
import ru.vsu.spring.blogapp.domain.exception.ResourceNotFoundException;
import ru.vsu.spring.blogapp.repository.ArticleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleEntity getById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
    }

    public ArticleEntity getByTitle(String title) {
        return articleRepository.findByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
    }

    public List<ArticleEntity> getAll() {
        return articleRepository.findAll();
    }

    public List<ArticleEntity> getAllByPublishDate(LocalDate date)
    {
        return articleRepository.findAllByPublishDate(date)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
    }

    @Transactional
    public ArticleEntity update(ArticleEntity article) {
        articleRepository.save(article);
        return article;
    }

    @Transactional
    public ArticleEntity create(ArticleEntity article) {
        Optional<ArticleEntity> foundedArticle = articleRepository.findByTitle(article.getTitle());
        if (foundedArticle.isPresent() && foundedArticle.get().getAuthorId() == article.getAuthorId()) {
                throw new IllegalStateException("Article already exists.");
        }
        articleRepository.save(article);
        return article;
    }

    public void delete(Long id) {
        articleRepository.delete(id);
    }

}
