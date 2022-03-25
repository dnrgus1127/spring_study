package com.example.demo.domain.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Configurable;



@Getter // lombok annotation // 클래스 내 모든 필드의 Getter메소드 자동생성
@NoArgsConstructor // lombok annotation // 기본 생성자 자동 추가 
@Entity  // JPA annotation
public class Posts { // Entity Class
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK Rules // GenerationType.IDENTITY -> 데이터 삽입 시점 마다 1증가 
    private long id;
    

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
