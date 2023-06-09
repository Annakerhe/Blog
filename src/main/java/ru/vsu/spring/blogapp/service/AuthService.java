package ru.vsu.spring.blogapp.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import ru.vsu.spring.blogapp.domain.exception.ResourceNotFoundException;
import ru.vsu.spring.blogapp.domain.jwt.JwtProvider;
import ru.vsu.spring.blogapp.domain.jwt.JwtRequest;
import ru.vsu.spring.blogapp.domain.jwt.JwtResponse;


@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthorService authorService;
    private final JwtProvider jwtProvider;

    public AuthService(AuthenticationManager authenticationManager,
                       AuthorService authorService,
                       JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.authorService = authorService;
        this.jwtProvider = jwtProvider;
    }

    public JwtResponse login(JwtRequest loginRequest) {
        var author = authorService.getByLogin(loginRequest.getLogin());
        if (author == null)
            throw new ResourceNotFoundException("Author not found");

        if (author.getPassword().equals(loginRequest.getPassword())) {
            JwtResponse jwtResponse = new JwtResponse();
            jwtResponse.setId(author.getId());
            jwtResponse.setLogin(author.getLogin());
            jwtResponse.setAccessToken(jwtProvider.createAccessToken(
                    author.getId(),
                    author.getLogin(),
                    author.getRoles()
            ));
            jwtResponse.setRefreshToken(jwtProvider.createRefreshToken(
                    author.getId(),
                    author.getLogin()
            ));
            return jwtResponse;
        } else
            throw new ResourceNotFoundException("Password not valid");
    }

    public JwtResponse refresh(String refreshToken) {
        return jwtProvider.refreshUserTokens(refreshToken);
    }
}
