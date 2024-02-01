package com.hahyeon.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    //jpa entity가 생성된 시간을 자동으로 생성
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdDateTime : LocalDateTime = LocalDateTime.now()

    //마지막으로 수정된 일시
    @LastModifiedDate
    @Column(nullable = false)
    var updatedDateTime : LocalDateTime = LocalDateTime.now()



}