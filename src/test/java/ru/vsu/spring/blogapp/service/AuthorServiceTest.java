package ru.vsu.spring.blogapp.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.vsu.spring.blogapp.domain.entity.Author;
import ru.vsu.spring.blogapp.domain.exception.ResourceNotFoundException;
import ru.vsu.spring.blogapp.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {
    public static final long ID = 1L;
    public static final long ID1 = 2L;
    public static final String USERNAME = "one";
    @Mock
    AuthorRepository authorRepoMock;

    @Test
    void testExpectedExceptionGetAll() {
        AuthorService authorService = new AuthorService(authorRepoMock);
        List<Author> emptyList = new ArrayList<>();
        when(authorRepoMock.findAll()). thenReturn(emptyList);
        Throwable exception =
                assertThrows(ResourceNotFoundException.class, authorService::getAll);
        assertEquals("Authors not found", exception.getMessage());

    }
    @Test
    void getAll() {
        AuthorService authorService = new AuthorService(authorRepoMock);
        when(authorRepoMock.findAll()). thenReturn(getAuthorsStub());
        List<Author> list = authorService.getAll();
        assertEquals(2, list.size());

        Author author = list.get(0);
        assertEquals(USERNAME,author.getUsername());
    }

    private List<Author> getAuthorsStub() {

        var entityOne = new Author();
        entityOne.setId(ID);
        entityOne.setUsername(USERNAME);


        var entityTwo =  new Author();
        entityTwo.setId(ID1);
        entityTwo.setUsername("two");

        return List.of(entityOne, entityTwo);

    }

}