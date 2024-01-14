package com.hahyeon.portfolio.domain.repository

import com.hahyeon.portfolio.domain.entity.*
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ProjectRepository : JpaRepository<Project, Long> {

    fun findAllByIsActive(isActive : Boolean) : List<Project>

    override fun findById(id:Long): Optional<Project>

}