package ru.vsu.spring.blogapp.domain.jwt;

import lombok.Data;

@Data
public class JwtResponse {
    private Long id;
    private String login;
    private String accessToken;
    private String refreshToken;

}
