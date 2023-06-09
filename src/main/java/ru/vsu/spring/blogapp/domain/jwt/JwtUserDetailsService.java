package ru.vsu.spring.blogapp.domain.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vsu.spring.blogapp.domain.entity.AuthorEntity;
import ru.vsu.spring.blogapp.service.AuthorService;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final AuthorService authorService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthorEntity author = authorService.getByLogin(username);
        return JwtEntityFactory.create(author);
    }
}