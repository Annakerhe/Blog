package ru.vsu.spring.blogapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
public class CommentDto {
    @NotBlank
    private int authorId;
    @NotBlank
    @Size(min = 4, max = 100)
    private String body;
}
