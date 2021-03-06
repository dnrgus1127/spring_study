package com.example.demo.web.dto;

import com.example.demo.domain.posts.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor // 파라미터가 없는 생성자를 생성해주는 annotation
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){ //Posts 생성자를 반환?
        return Posts.builder()
        .title(title)
        .content(content)
        .author(author)
        .build();
    }
}
