package ru.vsu.spring.blogapp.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.vsu.spring.blogapp.domain.entity.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
@Data
@AllArgsConstructor
public class AuthorDto {
    @NotBlank (message = "Name cannot be empty")
    @Size(min = 4, max = 100)
    private String username;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password cannot be empty")
    private String password;

    private Short age;
    private String tag;
    private Set<Role> roles;

}
