package com.example.first_springboot.service;

import com.example.first_springboot.dto.CommentDto;
import com.example.first_springboot.entity.Article;
import com.example.first_springboot.entity.Comment;
import com.example.first_springboot.repository.ArticleRepository;
import com.example.first_springboot.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.yaml.snakeyaml.comments.CommentType;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
        //조회 : 댓들 목록
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        // 변환 : 엔티티 -> Dto
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for (int i = 0; i < comments.size(); i++) {
            Comment c = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);

        }
        //반환
//        return commentRepository.findByArticleId(articleId)
//                .stream()
//                .map(comment -> CommentDto.createCommentDto(comment))
//                .collect(Collectors.toList());

        return dtos;
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        //게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다."));
        // 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto,article);

        // 댓글 엔티티를 DB로 저장
        Comment create = commentRepository.save(comment);
        // DTO 를 변경하여 변환
        return CommentDto.createCommentDto(create);
    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        // 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다."));
        // 댓글 수정
        target.patch(dto);
        // DB로 갱신
        Comment updated = commentRepository.save(target);
        // 댓글 엔티티를 DTO로 변환 및 반환
        return CommentDto.createCommentDto(updated);
    }

    @Transactional
    public CommentDto delete(Long id) {
        // 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! 대상 댓글이 없습니다."));
        // 댓글 삭제
        commentRepository.delete(target);
        // 삭제 댓글  DTO로 반환
        return CommentDto.createCommentDto(target);
    }
}
