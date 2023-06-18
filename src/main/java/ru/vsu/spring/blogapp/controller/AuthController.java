package ru.vsu.spring.blogapp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.spring.blogapp.controller.mapper.AuthorMapper;
import ru.vsu.spring.blogapp.domain.dto.AuthorDto;
import ru.vsu.spring.blogapp.domain.entity.AuthorEntity;
import ru.vsu.spring.blogapp.domain.jwt.JwtRequest;
import ru.vsu.spring.blogapp.domain.jwt.JwtResponse;
import ru.vsu.spring.blogapp.service.AuthService;
import ru.vsu.spring.blogapp.service.AuthorService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final AuthService authService;
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public AuthorDto register(@RequestBody AuthorDto authorDto) {
        AuthorEntity author = authorMapper.toEntity(authorDto);
        AuthorEntity createdAuthor = authorService.create(author);
        return authorMapper.toDto(createdAuthor);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }
}