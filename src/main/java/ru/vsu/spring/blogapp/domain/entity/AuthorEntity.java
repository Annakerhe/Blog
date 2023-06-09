package ru.vsu.spring.blogapp.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.vsu.spring.blogapp.domain.Role;
import ru.vsu.spring.blogapp.domain.StatusType;

import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name = "author")
public class AuthorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

//    @Column(columnDefinition = "roles[]")
    private String roles;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private Short age;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    @OneToMany(mappedBy = "authorByAuthorId")
    private Collection<ArticleEntity> articlesById;

    @OneToMany(mappedBy = "authorByAuthorId")
    private Collection<CommentEntity> commentsById;

}