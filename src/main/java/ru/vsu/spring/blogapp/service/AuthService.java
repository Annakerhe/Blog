package ru.vsu.spring.blogapp.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.vsu.spring.blogapp.domain.Role;
import ru.vsu.spring.blogapp.domain.entity.AuthorEntity;
import ru.vsu.spring.blogapp.domain.exception.ResourceNotFoundException;
import ru.vsu.spring.blogapp.domain.jwt.JwtProvider;
import ru.vsu.spring.blogapp.domain.jwt.JwtRequest;
import ru.vsu.spring.blogapp.domain.jwt.JwtResponse;

import java.util.Set;

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

    //@Override
    public JwtResponse login(JwtRequest loginRequest) {
/*        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getLogin(),
                        loginRequest.getPassword()
                )
        );*/
        AuthorEntity author = authorService.getByLogin(loginRequest.getLogin());
        if (author == null)
            new ResourceNotFoundException("Author not found");

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
    }

    // @Override
    public JwtResponse refresh(String refreshToken) {
        return jwtProvider.refreshUserTokens(refreshToken);
    }
}
