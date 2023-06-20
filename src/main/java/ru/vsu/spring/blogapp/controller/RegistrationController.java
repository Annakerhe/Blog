package ru.vsu.spring.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vsu.spring.blogapp.domain.entity.Author;
import ru.vsu.spring.blogapp.service.AuthorService;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    public static final String REGISTRATION = "registration";
    @Autowired
    private AuthorService authorService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("authorForm", new Author());
        return REGISTRATION;
    }

    @PostMapping("/registration")
    public String addAuthor(@ModelAttribute("authorForm") @Valid Author authorForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return REGISTRATION;
        }
        if (!authorForm.getPassword().equals(authorForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return REGISTRATION;
        }
        if (!authorService.save(authorForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return REGISTRATION;
        }

        return "redirect:/";
    }
}
