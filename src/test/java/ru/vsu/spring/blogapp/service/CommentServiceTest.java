package ru.vsu.spring.blogapp.service;


import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import ru.vsu.spring.blogapp.BlogApplicationTests;
import ru.vsu.spring.blogapp.domain.entity.Comment;

import java.time.LocalDate;
import java.util.List;



@ContextConfiguration(classes = {CommentService.class})
class CommentServiceTest extends BlogApplicationTests {
/*
    @MockBean
    private CommentService commentService;

    @Test
    void getAllByArticleId() {
        Long testArticleId = 101L;

        when(commentService.getAllByArticleId(any())).thenReturn(getCommentStub());
        List<Comment> allByArticleId = commentService.getAllByArticleId(testArticleId);
        assertEquals(2, allByArticleId.size());

        Comment commentOne = allByArticleId.get(0);
        assertTrue(commentOne.getBody().contains("Один"));
    }

    private List<Comment> getCommentStub() {

        var entityOne = new Comment();
        entityOne.setId(1L);
        entityOne.setAuthorId(1L);
        entityOne.setArticleId(101L);
        entityOne.setPublishDate(LocalDate.now().minusDays(20));
        entityOne.setBody("Тестовый Артикель номер Один");

        var entityTwo = new Comment();
        entityTwo.setId(2L);
        entityTwo.setAuthorId(2L);
        entityTwo.setArticleId(101L);
        entityTwo.setPublishDate(LocalDate.now().minusDays(10));
        entityTwo.setBody("Тестовый Артикель номер Два");

        return List.of(entityOne, entityTwo);

    }

 */

}