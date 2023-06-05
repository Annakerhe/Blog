package ru.vsu.spring.blogapp.controller;


import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vsu.spring.blogapp.controller.mapper.ArticleMapper;
import ru.vsu.spring.blogapp.domain.dto.ArticleDto;
import ru.vsu.spring.blogapp.domain.entity.ArticleEntity;
import ru.vsu.spring.blogapp.service.ArticleService;


import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/blog/article")
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @GetMapping("/")
    public List<ArticleDto> getAllArticles() {
        return articleMapper.toDto(articleService.getAll());
    }

    @GetMapping("/{id}")
    public ArticleDto getById(@PathVariable Long id) {
        return  articleMapper.toDto(articleService.getById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<ArticleEntity> addArticle (@RequestBody ArticleEntity article)
    {
        //if(validator.isValidArticle(article))
        {
            var createdArticle = articleService.create(article);
           // from articleDTO, createdArticle.setId(());
            return ResponseEntity.ok().body(createdArticle);
        }
       // return ResponseEntity.badRequest().body(new ArticleEntity());
    }

    @PutMapping("/update")
    public ResponseEntity<ArticleEntity>  updateContent( @RequestBody ArticleEntity article) {
       // if(validator.isValidArticle(article))
        {
            var updatedArticle = articleService.update(article);
            // from articleDTO, createdArticle.setId(());
            return ResponseEntity.ok().body(updatedArticle);
        }
       // return ResponseEntity.badRequest().body(new ArticleEntity());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        articleService.delete(id);
    }

}
