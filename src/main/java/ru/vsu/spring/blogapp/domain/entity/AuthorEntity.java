package ru.vsu.spring.blogapp.domain.entity;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import ru.vsu.spring.blogapp.domain.Role;
import ru.vsu.spring.blogapp.domain.StatusType;

import java.util.Collection;

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

    @Type(StringArrayType.class)
    @Column(name = "roles", columnDefinition = "text[]")
    private String[] roles;

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