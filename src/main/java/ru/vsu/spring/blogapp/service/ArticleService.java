package ru.vsu.spring.blogapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.spring.blogapp.domain.entity.Article;
import ru.vsu.spring.blogapp.domain.exception.ResourceNotFoundException;
import ru.vsu.spring.blogapp.repository.ArticleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    public static final String ARTICLE_NOT_FOUND = "Article not found";
    private final ArticleRepository articleRepository;

    public Article getById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ARTICLE_NOT_FOUND));
    }

    public Article getByTitle(String title) {
        return articleRepository.findByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException(ARTICLE_NOT_FOUND));
    }

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public List<Article> getAllByPublishDate(LocalDate date)
    {
        return articleRepository.findAllByPublishDate(date)
                .orElseThrow(() -> new ResourceNotFoundException(ARTICLE_NOT_FOUND));
    }

    @Transactional
    public Article update(Article article) {
        articleRepository.save(article);
        return article;
    }

    @Transactional
    public Article create(Article article) {
        Optional<Article> foundedArticle = articleRepository.findByTitle(article.getTitle());
        if (foundedArticle.isPresent() && foundedArticle.get().getAuthorId().equals(article.getAuthorId())) {
                throw new IllegalStateException("Article already exists.");
        }
        return articleRepository.save(article);
    }

    public void delete(Long id) {
        articleRepository.delete(id);
    }

}
