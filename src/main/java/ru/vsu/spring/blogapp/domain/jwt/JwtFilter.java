package ru.vsu.spring.blogapp.domain.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import ru.vsu.spring.blogapp.domain.exception.ResourceNotFoundException;

import java.io.IOException;

@AllArgsConstructor
public class JwtFilter extends GenericFilterBean {
    private final JwtProvider jwtProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String bearerToken = ((HttpServletRequest) servletRequest).getHeader("Authorization");
        if (bearerToken != null &&
                bearerToken.startsWith("Bearer ")) {
            bearerToken = bearerToken.substring(7);
            if (jwtProvider.validateToken(bearerToken)) {
                try {
                    Authentication authentication = jwtProvider.getAuthentication(bearerToken);
                    if (authentication != null) {
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                } catch (ResourceNotFoundException ignored) {
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}