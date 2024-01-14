package com.hahyeon.portfolio.domain.repository

import com.hahyeon.portfolio.domain.entity.*
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long> {

    //select * from project_skill where project_id = :projectId and skill_id =: skillId
    fun findByProjectIdAndSkillId(projectId: Long, skillId: Long) : Optional<Project>
    
}