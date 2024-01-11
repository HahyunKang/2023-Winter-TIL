package com.hahyeon.portfolio.domain.repository

import com.hahyeon.portfolio.domain.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long> {
    
}