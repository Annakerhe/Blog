package ru.vsu.spring.blogapp.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CommentDto {
    @NotBlank
    private int authorId;
    @NotBlank
    @Size(min = 4, max = 100)
    private String body;
}
