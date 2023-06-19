package ru.vsu.spring.blogapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog/auth")
@RequiredArgsConstructor
@Validated
//@Tag(name = "Auth controller", description = "Auth API")
public class AuthController {
    /*
    private final AuthService authService;
    private final AuthorService profileService;
    private final AuthorMapper profileMapper;

    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public AuthorDto register( @RequestBody AuthorDto authorDto) {
        Author author = profileMapper.toEntity(authorDto);
        Author author1 = profileService.create(author);
        return profileMapper.toDto(author1);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }
    */
}