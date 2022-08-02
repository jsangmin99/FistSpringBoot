package com.example.first_springboot.service;

import com.example.first_springboot.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest // 해당 클래스는 스프링 부트와 연동되어 테스팅된다
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {

        //예상
        Article a = new Article(1L, "가가가", "1111");
        Article b = new Article(2L, "나나나", "2222");
        Article c = new Article(4L, "다다다", "3333");
        List<Article> expected  = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제
        List<Article> articles = articleService.index();
        //비교
        assertEquals(expected.toString(), articles.toString());
    }
    @Test
    void show성공(){
        //에상
        Long id = 1L;

        Article expected = new Article(id, "가가가", "1111");

        //실제
        Article article = articleService.show(id);

        //비교
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void show실패(){
        //에상
        Long id = -1L;
        Article expected = null;

        //실제
        Article article = articleService.show(id);

        //비교
        assertEquals(expected, article);

    }
}