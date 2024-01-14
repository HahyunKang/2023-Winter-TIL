package com.hahyeon.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class ExperienceDetail(content : String, isActive : Boolean) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="experience_detail_id")
    //테이블 명은 _id, 코틀린 entity는 id -> 직관적으로 변수 사용 가능
    var id: Long? = null

    var content : String = content

    var isActive : Boolean  = isActive

    fun update(content : String, isActive: Boolean){
        this.content = content
        this.isActive = isActive
    }
}