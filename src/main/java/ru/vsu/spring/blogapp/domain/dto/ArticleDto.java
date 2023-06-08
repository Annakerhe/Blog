package ru.vsu.spring.blogapp.domain.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDto {
    @NotBlank
   private int authorId;
   @NotBlank
   @Size(min = 4, max = 100)
    private String title;
    @NotBlank
    @Size(min = 4, max = 255)
    private String body;
    //private Date publishDate;

}
