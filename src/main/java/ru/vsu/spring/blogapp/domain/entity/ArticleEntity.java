package ru.vsu.spring.blogapp.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@Data
@Entity
@Table(name = "article")
public class ArticleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "author_id", insertable=false, updatable=false)
    private int authorId;

    @Column(name = "title")
    private String title;

    @CreatedDate
    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "body")
    private String body;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private AuthorEntity authorByAuthorId;
}