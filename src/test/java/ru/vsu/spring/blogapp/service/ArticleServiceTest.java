package ru.vsu.spring.blogapp.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.vsu.spring.blogapp.domain.entity.Article;
import ru.vsu.spring.blogapp.domain.exception.ResourceNotFoundException;
import ru.vsu.spring.blogapp.repository.ArticleRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ArticleServiceTest {
    public static final long ID = 1L;
     private final ArticleRepository articleRepoMock = Mockito.mock(ArticleRepository.class);
    private final ArticleService articleService = new ArticleService(articleRepoMock);

    @Test
    void testExpectedExceptionGetById() {
        when(articleRepoMock.findById(any())). thenReturn(Optional.empty());
        Throwable exception =
                assertThrows(ResourceNotFoundException.class, () -> articleService.getById(ID));
        assertEquals("Article not found", exception.getMessage());
    }

    @Test
    void getById() {
        var article = getArticleStub();
        when(articleRepoMock.findById(any())). thenReturn(Optional.of(article));
        var res = articleService.getById(ID);

        assertEquals(article, res);
    }


    @Test
    void testExpectedExceptionCreate() {
        Article article = getArticleStub();
        when(articleRepoMock.findByTitle(any())).thenReturn(Optional.of(article));
        Throwable exception =
                assertThrows(IllegalStateException.class, () -> articleService.create(article));
        assertEquals("Article already exists.", exception.getMessage());
    }
    @Test
    void create() {
        Article article = getArticleStub();
        when(articleRepoMock.findByTitle(any())).thenReturn(Optional.empty());
        when(articleRepoMock.save(any())).thenReturn(article);
        var res = articleService.create(article);

        assertEquals(article,res);
    }

    private Article getArticleStub (){
        Article article = new Article();
        article.setId(ID);
        article.setAuthorId(ID);
        article.setTitle("title");
        article.setBody("text");
        article.setPublishDate(LocalDate.of(2020,1,1));
        return  article;
    }

}