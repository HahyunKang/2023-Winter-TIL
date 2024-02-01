package com.hahyeon.portfolio.admin.context.achievement.service

import com.hahyeon.portfolio.admin.data.TableDto
import com.hahyeon.portfolio.domain.entity.Achievement
import com.hahyeon.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {
    fun getAchievementTable() : TableDto{
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDto.from(classInfo,entities)
    }
}