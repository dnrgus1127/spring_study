package com.example.demo.domain.posts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PostsRepository extends JpaRepository<Posts,Long>{
    
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") //쿼리문을 이용한 DB 조회 
    List<Posts> findAllDesc();
}
