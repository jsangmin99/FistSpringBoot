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
    }

    @Test
    void findByNickname() {
    }
}