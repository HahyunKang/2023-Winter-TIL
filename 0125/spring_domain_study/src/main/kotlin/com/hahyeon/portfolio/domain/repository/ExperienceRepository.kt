package com.hahyeon.portfolio.domain.repository

import com.hahyeon.portfolio.domain.entity.Achievement
import com.hahyeon.portfolio.domain.entity.Experience
import com.hahyeon.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ExperienceRepository : JpaRepository<Experience, Long> {

    @Query("select e from Experience e left join fetch e.details where e.isActive = :isActive")
    fun findAllByIsActive(isActive : Boolean) : List<Experience>

    @Query("select e from Experience e left join fetch e.details where e.id = :id")
    override fun findById(id: Long): Optional<Experience>
}