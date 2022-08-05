package com.example.first_springboot.service;

import com.example.first_springboot.dto.ArticleForm;
import com.example.first_springboot.entity.Article;
import com.example.first_springboot.repository.ArticleRepository;
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
    void update_성공_존재하는id_title_content가_있는_dto입력 () {

        //에상
        String title ="갸갸갸";
        String content = "1111";
        ArticleForm dto = new ArticleForm(1L,title,content);
        Article expected = new Article(1L,title,content);

        //실제
        Article article = articleService.update(1L, dto);

        //비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test////////////////////////// content의 값
    void update_성공_존재하는id_title_있는_dto입력 () {

        //에상
        String title ="갸갸갸";
        String content = null;
        ArticleForm dto = new ArticleForm(1L,title,content);
        Article expected = new Article(1L,title,"1111");//content 부분을 기존걸 가져오고 싶다~~

        //실제
        Article article = articleService.update(1L, dto);

        //비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void update_실패_존재하지않는id() {
        //예상
        Long id = -1L;
        String title = "라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id,title, content);
        Article expected = null;

        //실제
        Article article = articleService.update(-1L,dto);
        //비교
        assertEquals(expected, article);

    }
    @Test
    void update_실패_id만_있는dto() { //실제값이 null로 반환해야하는데 기존값을 그대로 가져오는 문제!!!
        Long id =1L;
        String title = null;
        String content = null;
        //예상
        ArticleForm dto = new ArticleForm(id,title, content);
        Article expected = null;

        //실제
        Article article = articleService.update(1L,dto);
        //비교
        assertEquals(expected, article);

    }
    @Test
    @Transactional
    void delete_성공_존재하는id입력() {
        Long id = 2L;
        //예상
        Article expected = null;

        //실제
        articleService.delete(id);
        Article article = articleService.show(id);
        //비교
        assertEquals(expected,article);

    }
    @Test
    void delete_실패_존재하지않는id입력() {
        Long id = -1L;
        //예상
        Article expected = null;

        //실제
        Article article = articleService.delete(id);
        //비교
        assertEquals(expected,article);
    }
}