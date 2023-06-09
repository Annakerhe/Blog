package ru.vsu.spring.blogapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.spring.blogapp.domain.entity.AuthorEntity;
import ru.vsu.spring.blogapp.domain.exception.ResourceNotFoundException;
import ru.vsu.spring.blogapp.repository.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorEntity getById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }

    public List<AuthorEntity> getAll() {
        var authorEntityList = authorRepository.findAll();
        if (authorEntityList.isEmpty()) throw new ResourceNotFoundException("Authors not found");
        return authorEntityList;
    }

    public AuthorEntity getByFullName(String fullName) {
        return authorRepository.findByFullName(fullName).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }
    public AuthorEntity getByLogin(String login) {
        return authorRepository.findByLogin(login)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }

    @Transactional
    public AuthorEntity update(AuthorEntity author) {
        authorRepository.save(author);
        return author;
    }

    @Transactional
    public AuthorEntity create(AuthorEntity author) {
        if (authorRepository.findByFullName(author.getFullName()).isPresent()) {
            throw new IllegalStateException("Author already exists.");
        }
        authorRepository.save(author);
        return author;
    }

    public void delete(Long id) {
        authorRepository.delete(id);
    }
}
