package ru.vsu.spring.blogapp.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity

public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(insertable=false, updatable=false)
    private Long authorId;

    @Column( insertable=false, updatable=false)
    private Long articleId;

    private LocalDate publishDate;

    private String body;

}
