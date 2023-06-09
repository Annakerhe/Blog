package ru.vsu.spring.blogapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vsu.spring.blogapp.controller.mapper.AuthorMapper;
import ru.vsu.spring.blogapp.domain.dto.AuthorDto;
import ru.vsu.spring.blogapp.domain.entity.AuthorEntity;
import ru.vsu.spring.blogapp.service.AuthorService;

import java.util.List;
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/blog/author")
public class AuthorController {
    private AuthorService authorService;
    private AuthorMapper authorMapper;
    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) {
        return authorMapper.toDto(authorService.getById(id));
    }

    @GetMapping("/")
    public List<AuthorDto> getAllAuthors() {
        return authorMapper.toDto(authorService.getAll());
    }

    @PostMapping("/add")
    public AuthorDto addAuthor(@RequestBody AuthorDto authorDto) {
        AuthorEntity author = authorMapper.toEntity(authorDto);
        AuthorEntity createdAuthor = authorService.create(author);
        return authorMapper.toDto(createdAuthor);
    }

    @PutMapping("/update")
    public AuthorDto updateAuthor(@RequestBody AuthorDto authorDto) {
        AuthorEntity author = authorMapper.toEntity(authorDto);
        AuthorEntity updatedAuthor = authorService.update(author);
        return authorMapper.toDto(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
    }
}
