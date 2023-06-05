package ru.vsu.spring.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.vsu.spring.blogapp.domain.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    //Optional<AuthorEntity> findById(Long id);

    // List<AuthorEntity> findAll();

    // Optional<AuthorEntity> findAllByTag


    Optional<AuthorEntity> findByFullName(String fullName);

    @Modifying
    @Query("DELETE FROM AuthorEntity WHERE id = :id")
    void delete(Long id);
}
