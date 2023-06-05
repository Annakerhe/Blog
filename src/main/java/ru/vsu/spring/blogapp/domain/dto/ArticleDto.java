package ru.vsu.spring.blogapp.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDto {
   // private int authorId;
    private String title;
    private String body;
    //private Date publishDate;

}
