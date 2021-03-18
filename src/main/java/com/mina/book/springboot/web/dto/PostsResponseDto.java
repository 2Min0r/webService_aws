package com.mina.book.springboot.web.dto;

import com.mina.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {     // Entity 필드의 일부만 사용하므로, Dto 생성자로 Entity 받아 필드에 값을 넣음.

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
