package ru.vsu.spring.blogapp.utils;

import org.springframework.stereotype.Component;
import ru.vsu.spring.blogapp.domain.entity.ArticleEntity;

@Component
public class Validator {
    public  boolean isValidArticle (final ArticleEntity artecle)
    {
        return true;
    }
}
