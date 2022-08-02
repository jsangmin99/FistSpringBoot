package com.example.first_springboot.service;

import com.example.first_springboot.dto.ArticleForm;
import com.example.first_springboot.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
        Article c = new Article(3L, "다다다", "3333");
        List<Article> expected  = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제
        List<Article> articles = articleService.index();
        //비교
        assertEquals(expected.toString(), articles.toString());
    }
    @Test
    void show성공_존재하는_id입력(){
        //에상
        Long id = 1L;

        Article expected = new Article(id, "가가가", "1111");

        //실제
        Article article = articleService.show(id);

        //비교
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void show실패_존재하지않는_id입력(){
        //에상
        Long id = -1L;
        Article expected = null;

        //실제
        Article article = articleService.show(id);

        //비교
        assertEquals(expected, article);

    }

    @Test
    @Transactional
    void create_성공_title과_content만_있는_DTO_입력() {

        //에상
        String title ="라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null,title,content);
        Article expected = new Article(4L,title,content);

        //실제
        Article article = articleService.create(dto);

        //비교
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void create_실패_id가_포함된_dto가_입력됐을때(){

        //에상
        String title ="라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L,title,content);
        Article expected = null;

        //실제
        Article article = articleService.create(dto);

        //비교
        assertEquals(expected, article);
    }

    @Test
    void update_성공() {

        //에상
        String title ="라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null,title,content);
        Article expected = new Article(4L,title,content);

        //실제
        Article article = articleService.create(dto);

        //비교
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void update_실패_존재하지않는id() {
    }
    @Test
    void update_실패_id만_있는dto() {
    }
    @Test
    void delete_성공() {

    }
    @Test
    void delete_성공_존재하지않는id입력() {
    }
}