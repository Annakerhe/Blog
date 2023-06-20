package ru.vsu.spring.blogapp.controller;


import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vsu.spring.blogapp.controller.mapper.ArticleMapper;
import ru.vsu.spring.blogapp.domain.dto.ArticleDto;
import ru.vsu.spring.blogapp.domain.entity.Article;
import ru.vsu.spring.blogapp.service.ArticleService;


import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
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
    public ArticleDto addArticle (@RequestBody ArticleDto articleDto)
    {
       Article article = articleMapper.toEntity(articleDto);
       Article createdArticle = articleService.create(article);
       createdArticle.setPublishDate(LocalDate.now());
       return articleMapper.toDto(createdArticle);
    }
    @PutMapping("/update")
    public ArticleDto  updateArticle( @RequestBody ArticleDto articleDto) {
        Article article = articleMapper.toEntity(articleDto);
        Article updatedArticle = articleService.update(article);
        return articleMapper.toDto(updatedArticle);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        articleService.delete(id);
    }

}
