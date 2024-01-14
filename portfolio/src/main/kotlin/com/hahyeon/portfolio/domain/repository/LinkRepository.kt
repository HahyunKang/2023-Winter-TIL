package com.hahyeon.portfolio.domain.repository

import com.hahyeon.portfolio.domain.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long> {

    fun findAllByIsActive(isActive : Boolean) : List<Link>

}