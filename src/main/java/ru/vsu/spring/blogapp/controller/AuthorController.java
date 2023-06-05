package ru.vsu.spring.blogapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vsu.spring.blogapp.domain.entity.AuthorEntity;
import ru.vsu.spring.blogapp.service.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blog/author")
public class AuthorController {
    private AuthorService authorService;
    @GetMapping("/{id}")
    public AuthorEntity getAuthorById(@PathVariable Long id) {
        AuthorEntity author = authorService.getById(id);
        return author;
    }

    @GetMapping
    public List<AuthorEntity> getAllAuthors() {
        List<AuthorEntity> authors = authorService.getAll();
        return authors;
    }

    @PostMapping("/add")
    public AuthorEntity addAuthor(@RequestBody AuthorEntity author) {
        AuthorEntity createdAuthor = authorService.create(author);
        return createdAuthor;
    }

    @PutMapping("/update")
    public AuthorEntity updatePerson(@RequestBody AuthorEntity author) {
        AuthorEntity updatedPerson = authorService.update(author);
        return updatedPerson;
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        authorService.delete(id);
    }



}
