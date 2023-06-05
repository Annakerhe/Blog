package ru.vsu.spring.blogapp.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthorDto {
    @NotBlank
    @Size(min = 4, max = 100)
    private String fullName;

    private Short age;

    private String tag;
}
