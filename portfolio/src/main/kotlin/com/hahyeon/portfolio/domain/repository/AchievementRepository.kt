package com.hahyeon.portfolio.domain.repository

import com.hahyeon.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long> {

}