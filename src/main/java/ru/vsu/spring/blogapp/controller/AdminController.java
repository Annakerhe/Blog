package ru.vsu.spring.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vsu.spring.blogapp.service.AuthorService;

@Controller
public class AdminController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/admin")
    public String authorList(Model model) {
        model.addAttribute("allAuthors", authorService.getAll());
        return "admin";
    }

    @PostMapping("/admin")
    public String  delete (@RequestParam(required = true, defaultValue = "" ) Long id,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            authorService.delete(id);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{id}")
    public String gtAuthor(@PathVariable("Id") Long id, Model model) {
        model.addAttribute("allAuthors", authorService.authorgtList(id));
        return "admin";
    }
}