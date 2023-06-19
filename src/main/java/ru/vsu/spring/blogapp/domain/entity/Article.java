package ru.vsu.spring.blogapp.domain.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "articles")
public class Article {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "author_id", insertable=false, updatable=false)
    private Long authorId;

    @Column(name = "title")
    private String title;

    @CreatedDate
    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "body")
    private String body;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Author authorByAuthorId;
}