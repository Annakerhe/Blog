package ru.vsu.spring.blogapp.domain.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Article {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(insertable = false, updatable = false)
    private Long authorId;

    private String title;

    @CreatedDate
    private LocalDate publishDate;

    private String body;
}