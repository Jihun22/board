package com.example.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter

public class BaseEntity {
    //생성되었을때 시간
    @CreationTimestamp
    @Column(updatable = false) // 수정시에는 관여 안함
    private LocalDateTime createdTime;


    //업데이트 되었을때 시간
    @UpdateTimestamp
    @Column(insertable = false) // 생성되었을때 (입력) 관여안함
    private LocalDateTime updatedTime;



}
