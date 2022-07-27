package com.example.first_springboot.controller;

import com.example.first_springboot.dto.ArticleForm;
import com.example.first_springboot.entity.Article;
import com.example.first_springboot.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticleController {
    @Autowired //스프링 부트가 미리 생성해놓는 객페를 가져다 자동으로 연결

    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());
        // System.out.println(form.toString()); -> sout를 로깅기능으로 대체
        //1.Dto 를 Entity로 변환
        Article article = form.toEntity();
        log.info(article.toString());

        //2. 리포지토리에게 엔티티를  DB 안에 저장하게함
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "";
    }
}

