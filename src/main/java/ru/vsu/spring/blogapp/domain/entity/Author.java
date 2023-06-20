package ru.vsu.spring.blogapp.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
@Entity

public class Author implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 4, max = 100, message = "Password more 3 and less 100")
    private String password;

    @Transient
    private String passwordConfirm;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 4, max = 100, message = "Name more 3 and less 100")
    private String username;

    private Short age;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

}