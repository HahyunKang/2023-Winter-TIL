package com.hahyeon.portfolio.domain.entity

import com.hahyeon.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
    name : String,
    type : String,
    isActive : Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="skill_id")
    //테이블 명은 _id, 코틀린 entity는 id -> 직관적으로 변수 사용 가능
    var id: Long? = null

    var name : String = name

    @Column(name = "skill_type")
    @Enumerated(value = EnumType.STRING)
    var type : SkillType = SkillType.valueOf(type)

    var isActive : Boolean  = isActive




}