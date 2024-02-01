package com.hahyeon.portfolio.domain.repository

import com.hahyeon.portfolio.domain.entity.Achievement
import com.hahyeon.portfolio.domain.entity.Experience
import com.hahyeon.portfolio.domain.entity.HttpInterface
import com.hahyeon.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long> {

    //select * from introduction where is_active = :isActive

    fun findAllByIsActive(isActive : Boolean) : List<Introduction>

}