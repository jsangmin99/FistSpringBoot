package com.example.first_springboot.dto;

import com.example.first_springboot.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString

public class ArticleForm {

    private String title;
    private String content;



    public Article toEntity() {
        return new Article(null,title, content);
    }
}
