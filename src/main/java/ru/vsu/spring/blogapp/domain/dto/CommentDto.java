package ru.vsu.spring.blogapp.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CommentDto {
    @NotBlank
    private int authorId;
    @NotBlank
    @Size(min = 4, max = 100)
    private String body;
}
