package ru.vsu.spring.blogapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.spring.blogapp.domain.entity.Author;
import ru.vsu.spring.blogapp.domain.entity.Role;
import ru.vsu.spring.blogapp.domain.exception.ResourceNotFoundException;
import ru.vsu.spring.blogapp.repository.AuthorRepository;
import ru.vsu.spring.blogapp.repository.RoleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private final AuthorRepository authorRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String fullname) throws UsernameNotFoundException {
        return authorRepository.findByUsername(fullname)
                .orElseThrow(() -> new UsernameNotFoundException("Author not found"));
    }
    public Author findUserById(Long id) {
        Optional<Author> userFromDb = authorRepository.findById(id);
        return userFromDb.orElse(new Author());
    }

    public Author getById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }

    public List<Author> getAll() {
        List<Author> authorEntityList = authorRepository.findAll();
        if (authorEntityList.isEmpty()) throw new ResourceNotFoundException("Authors not found");
        return authorEntityList;
    }

    @Transactional
    public Author update(Author author) {
        authorRepository.save(author);
        return author;
    }

    @Transactional
    public Author create(Author author) {
        if (authorRepository.findByUsername(author.getUsername()).isPresent()) {
            throw new IllegalStateException("Author already exists.");
        }
        authorRepository.save(author);
        return author;
    }
    @Transactional
    public boolean save(Author author) {
       if( authorRepository.findByUsername(author.getUsername()).isPresent())
        {
            return false;
        }
        author.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        author.setPassword(bCryptPasswordEncoder.encode(author.getPassword()));
        authorRepository.save(author);
        return true;
    }
    @Transactional
    public void delete(Long id) {
        if (authorRepository.findById(id).isPresent()) {
            authorRepository.deleteById(id);
        }
    }
    public List<Author> authorgtList(Long idMin) {
        return em.createQuery("SELECT a FROM Author a WHERE a.id > :paramId", Author.class)
                .setParameter("paramId", idMin).getResultList();
    }

}
