package com.mina.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass       // BaseTimeEntity 상속할 경우, 필드를 칼럼으로 인식하게 함
@EntityListeners(AuditingEntityListener.class)      // Auditing 기능 포함
public abstract class BaseTimeEntity {      // 모든 Entity 상위 클래스가 되어 createdDate, modifiedDate 관리함

    @CreatedDate        // Entity 생성시간 저장
    private LocalDateTime createdDate;

    @LastModifiedDate   // Entity 변경시간 저장
    private LocalDateTime modifiedDate;

}
