package ru.vsu.spring.blogapp.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import ru.vsu.spring.blogapp.domain.Role;

import java.util.Set;

public class AuthorDto {
    @NotBlank
    @Size(min = 4, max = 100)
    private String fullName;
    @NotNull(message = "login cannot be empty")
    private String login;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "password cannot be empty")
    private String password;

    private Short age;

    private String tag;
    private Set<Role> roles;
}
