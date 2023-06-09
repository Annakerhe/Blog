package ru.vsu.spring.blogapp.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "comment")
public class CommentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "author_id", insertable=false, updatable=false)
    private Long authorId;

    @Column(name = "article_id", insertable=false, updatable=false)
    private Long articleId;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "body")
    private String body;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private AuthorEntity authorByAuthorId;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id", nullable = false)
    private ArticleEntity articleByArticleId;

}
