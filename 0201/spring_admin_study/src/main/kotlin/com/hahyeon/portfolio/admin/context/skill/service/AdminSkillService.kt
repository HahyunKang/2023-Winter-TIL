package com.hahyeon.portfolio.admin.context.skill.service

import com.hahyeon.portfolio.admin.data.TableDto
import com.hahyeon.portfolio.domain.entity.Achievement
import com.hahyeon.portfolio.domain.entity.Skill
import com.hahyeon.portfolio.domain.repository.AchievementRepository
import com.hahyeon.portfolio.domain.repository.ProjectSkillRepository
import org.springframework.stereotype.Service

@Service
class AdminSkillService(
    private val skillRepository: ProjectSkillRepository) {
    fun getSkillTable() : TableDto{
        val classInfo = Skill ::class
        val entities = skillRepository.findAll()

        return TableDto.from(classInfo,entities)
    }
}