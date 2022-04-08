package com.example.demo.domain;
import lombok.Getter;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Getter
@MappedSuperclass // JPA Entity 클래스들이 해당 클래스를 상속할 경우 필드도 Colum으로 인식하도록 한다
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 포함시킴
public class BaseTimeEntity {
    
    @CreatedDate // 저장될 때 시간이 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 엔티티의 값을 변경할 때 시간 자동 저장
    private LocalDateTime modifiedDate;
    
}
