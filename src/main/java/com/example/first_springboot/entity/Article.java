package com.example.first_springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity // DB가 해당 객체를 인식 가능
@AllArgsConstructor
@NoArgsConstructor//디폴트 생성자
@ToString
@Getter
public class Article {
    @Id // 대표값을 지정!
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 ID를 자동생
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public boolean patch(Article article) {
        if(article.title != null){
            this.title=article.title;
            return true;
        }
        if (article.content != null){
            this.content = article.content;
            return true;
        }
        return false;
    }
}
