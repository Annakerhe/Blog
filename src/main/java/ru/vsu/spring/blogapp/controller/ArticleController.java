package ru.vsu.spring.blogapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.spring.blogapp.domain.entity.ArticleEntity;
import ru.vsu.spring.blogapp.service.ArticleService;
import ru.vsu.spring.blogapp.utils.Validator;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blog/article")
public class ArticleController {
    private final ArticleService articleService;
    private final Validator validator;

    @GetMapping
    public ResponseEntity<List<ArticleEntity>> getAllArticles() {
        var response = articleService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ArticleEntity getById(@PathVariable Long id) {
        ArticleEntity article = articleService.getById(id);
        return article;

        // articleMapper.toDto(article);
    }
    @PostMapping("/add")
    public ResponseEntity<ArticleEntity> addArticle (@RequestBody ArticleEntity article)
    {
        if(validator.isValidArticle(article)) {
            var createdArticle = articleService.create(article);
           // from articleDTO, createdArticle.setId(());
            return ResponseEntity.ok().body(createdArticle);
        }
        return ResponseEntity.badRequest().body(new ArticleEntity());
    }

    @PutMapping("/update")
    public ResponseEntity<ArticleEntity>  updateContent( @RequestBody ArticleEntity article) {
        if(validator.isValidArticle(article)) {
            var updatedArticle = articleService.update(article);
            // from articleDTO, createdArticle.setId(());
            return ResponseEntity.ok().body(updatedArticle);
        }
        return ResponseEntity.badRequest().body(new ArticleEntity());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        articleService.delete(id);
    }
}
