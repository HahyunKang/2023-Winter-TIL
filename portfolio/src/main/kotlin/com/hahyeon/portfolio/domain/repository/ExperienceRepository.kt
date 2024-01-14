package com.hahyeon.portfolio.domain.repository

import com.hahyeon.portfolio.domain.entity.Achievement
import com.hahyeon.portfolio.domain.entity.Experience
import com.hahyeon.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long> {

    fun findAllByIsActive(isActive : Boolean) : List<Experience>
    
}