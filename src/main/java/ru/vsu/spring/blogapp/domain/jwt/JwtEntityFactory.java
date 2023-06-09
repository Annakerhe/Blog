package ru.vsu.spring.blogapp.domain.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.vsu.spring.blogapp.domain.Role;
import ru.vsu.spring.blogapp.domain.entity.AuthorEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JwtEntityFactory {
    public static JwtEntity create(AuthorEntity author) {
        return new JwtEntity(
                author.getId(),
                author.getLogin(),
                author.getPassword(),
                author.getFullName(),
                mapToGrantedAuthorities(List.of(author.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> roles) {
        return roles.stream()
//                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
