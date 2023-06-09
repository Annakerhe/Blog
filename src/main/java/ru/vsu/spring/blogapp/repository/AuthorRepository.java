package ru.vsu.spring.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.vsu.spring.blogapp.domain.entity.AuthorEntity;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findByFullName(String fullName);

    Optional<AuthorEntity> findByLogin(String login);

    @Modifying
    @Query("DELETE FROM AuthorEntity WHERE id = :id")
    void delete(Long id);

}
