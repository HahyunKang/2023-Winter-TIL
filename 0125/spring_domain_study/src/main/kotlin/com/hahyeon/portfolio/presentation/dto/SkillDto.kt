package com.hahyeon.portfolio.presentation.dto

import com.hahyeon.portfolio.domain.entity.Skill

data class SkillDto(
    val name: String,
    val type : String
){
    constructor(skill : Skill) : this(
        name = skill.name,
        type = skill.type.name
    )

}