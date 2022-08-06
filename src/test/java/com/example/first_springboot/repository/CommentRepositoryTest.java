package com.example.first_springboot.repository;

import com.example.first_springboot.entity.Article;
import com.example.first_springboot.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest // JPA 와 연동한 테스트
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        //case 1 : 4번 게시글의 모든 댓글 조회
        {
            //입력데이터 준비
            Long articleId = 4L;

            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            //예상하기
            Article article = new Article(4L, "너가 좋아하는 음식", "댓글ㄱ");
            Comment a = new Comment(1L, article, "park", "피자");
            Comment b = new Comment(2L, article, "kim", "치킨");
            Comment c = new Comment(3L, article, "Lee", "족발");
            List<Comment> expected = Arrays.asList(a, b, c);
            //검증
            assertEquals(expected.toString(),comments.toString(), "4번글의 모든 댓글을 출력!");
        }
        //case 2 : 1번 게시글의 모든 댓글 조회
        {
            //입력데이터 준비
            Long articleId = 1L;

            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            //예상하기
            Article article = new Article(1L,"가가가가","1111");
            List<Comment> expected = Arrays.asList();

            //검증
            assertEquals(expected.toString(), comments.toString());
        }
        // case3 : 9번 게시글의 모든 댓글 조회
        {}
        // case4 : 9999번 게시글의 모든 댓글 조회
        {}
        // case5 : -1번 게시글의 모든 댓글 조회
        {}
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        // case 1 : "park" 의 모든 댓글 조회
        {
            //입력데이터 준비
            String nickname = "park";
            //실제 수행
            List<Comment>comments =  commentRepository.findByNickname(nickname);
            //예상하기
            Article article = new Article(4L, "너가 좋아하는 음식", "댓글ㄱ");
            Comment a = new Comment(1L, new Article(4L, "너가 좋아하는 음식", "댓글ㄱ"), "park", "피자");
            Comment b = new Comment(4L, new Article(5L, "너가 좋아하는 색깔","댓글ㄱㄱ"), "park", "빨강");
            Comment c = new Comment(7L, new Article(6L, "너의 습관","댓글ㄱㄱ"), "park", "다리떨기");
            List<Comment> expected = Arrays.asList(a, b, c);

            //검증
            assertEquals(expected.toString(), comments.toString(), "park의 모든 댓글 출력");
        }
        // case 2 : "park" 의 모든 댓글 조회

        // case 3 : null 의 모든 댓글 조회
        // case 4 : "" 의 모든 댓글 조회
        // case 5 : "i" 가 들어있는 모든 댓글 조회
    }
}