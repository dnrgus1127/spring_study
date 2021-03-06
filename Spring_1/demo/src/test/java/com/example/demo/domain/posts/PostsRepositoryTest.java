package com.example.demo.domain.posts;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


//@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 단위 테스트가 끝날 때마다 수행되는 메소드
    public void cleanup() {
       postsRepository.deleteAll(); // 테스트용 데이터베이스인 H2에 데이터가 남아있어서 발생하는 오류 방지
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        //Long ID = 0L;

        postsRepository.save(Posts.builder() // posts테이블에 쿼리 실행 id 지정시update 미지정시 insert           
            .title(title)
            .content(content)
            .author("jojoldu@gmail.com")
            .build()
            );

        //when                    
        List<Posts> postsList = postsRepository.findAll(); // posts테이블의 모든 데이터 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
        .title("title")
        .author("author")
        .content("content")
        .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>> createDate=" + posts.getCreatedDate()+", modifiedDate="+ posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
