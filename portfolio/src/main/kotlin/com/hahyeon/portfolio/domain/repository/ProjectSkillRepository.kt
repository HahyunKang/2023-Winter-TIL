package com.hahyeon.portfolio.domain.repository

import com.hahyeon.portfolio.domain.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long> {
    
}