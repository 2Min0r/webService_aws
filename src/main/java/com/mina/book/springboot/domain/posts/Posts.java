package com.mina.book.springboot.domain.posts;

import com.mina.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  // 기본 생성자 자동추가
@Entity     // 테이블과 링크될 클래스
public class Posts extends BaseTimeEntity {

    @Id     // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // PK 생성 규칙, IDENTITY: auto_increment(PK는 long, auto_increment 추천)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // Column 생략 가능
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
