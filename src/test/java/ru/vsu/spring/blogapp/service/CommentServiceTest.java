package ru.vsu.spring.blogapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.vsu.spring.blogapp.domain.entity.Comment;

import ru.vsu.spring.blogapp.repository.CommentRepository;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


//@ContextConfiguration(classes = {CommentService.class})

@ExtendWith(MockitoExtension.class) // register the Mockito extension
class CommentServiceTest {
    public static final long ID = 1L;
    @Mock  // Instruct Mockito to mock this object
    private CommentRepository commentRepo;

    @Test
    void create() {
        CommentService commentService = new CommentService(commentRepo);
        var entityOne = getCommentStub();
        when(commentRepo.save(any())).thenReturn(entityOne);
        Comment comment = commentService.create(entityOne);
        Assertions.assertEquals(LocalDate.now(),comment.getPublishDate());
    }
    Comment getCommentStub (){
        var entity = new Comment();
        entity.setId(ID);
        entity.setAuthorId(ID);
        entity.setArticleId(ID);
        entity.setBody("Тестовый комментарий");
        return entity;
    }

    /*
    @Mock
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
  private List<Comment> getCommentsStub() {

        var entityOne = new Comment();
        entityOne.setId(1L);
        entityOne.setAuthorId(1L);
        entityOne.setArticleId(101L);
        entityOne.setPublishDate(LocalDate.now().minusDays(20));
        entityOne.setBody("Тестовый комментарий номер Один");

        var entityTwo = new Comment();
        entityTwo.setId(2L);
        entityTwo.setAuthorId(2L);
        entityTwo.setArticleId(101L);
        entityTwo.setPublishDate(LocalDate.now().minusDays(10));
        entityTwo.setBody("Тестовый комментарий номер Два");

        return List.of(entityOne, entityTwo);

    }
*/
}