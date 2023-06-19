package ru.vsu.spring.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.spring.blogapp.domain.entity.Author;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByUsername(String fullName);


   /* @Modifying
    @Query("DELETE FROM AuthorEntity WHERE id = :id")
    void delete(Long id);
*/
}
