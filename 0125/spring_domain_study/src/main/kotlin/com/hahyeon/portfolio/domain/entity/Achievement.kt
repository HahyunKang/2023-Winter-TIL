package com.hahyeon.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
class Achievement(title : String, description : String, achievedDate : LocalDate,host : String,isActive : Boolean) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="achievement_id")
    //테이블 명은 _id, 코틀린 entity는 id -> 직관적으로 변수 사용 가능
    var id: Long? = null

    var title : String = title

    var description : String = description

    var achievedDate : LocalDate? = achievedDate

    var host : String = host

    var isActive : Boolean  = isActive


}