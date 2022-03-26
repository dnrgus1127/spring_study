package com.example.demo.service.posts;

import lombok.RequiredArgsConstructor;

import com.example.demo.domain.posts.PostsRepository;
import com.example.demo.web.dto.PostsSaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor // final 선언된 필드에 대한 생성자 생성해주는 Annotation
@Service
public class PostsService {
    private final PostsRepository postsRepository; // JPA로 Posts 엔티티에 데이터 삽입하는 

    @Transactional // 트랜잭션 처리
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getID();
    }
}
