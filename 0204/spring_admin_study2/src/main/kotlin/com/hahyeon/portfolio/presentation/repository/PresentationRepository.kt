package com.hahyeon.portfolio.presentation.repository

import com.hahyeon.portfolio.domain.entity.*
import com.hahyeon.portfolio.domain.repository.*
import org.springframework.stereotype.Service

@Service
class PresentationRepository(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectSkillRepository: ProjectSkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {
    fun getActiveAchievements() : List<Achievement>{
        return achievementRepository.findAllByIsActive(true)
    }
    fun getActiveExperience() : List<Experience>{
        return experienceRepository.findAllByIsActive(true)
    }
    fun getActiveIntroduction() : List<Introduction>{
        return introductionRepository.findAllByIsActive(true)
    }
    fun getActiveLinks() : List<Link>{
        return linkRepository.findAllByIsActive(true)
    }  fun getActiveProjects() : List<Project>{
        return projectRepository.findAllByIsActive(true)
    }  fun getActiveSkills() : List<Skill>{
        return skillRepository.findAllByIsActive(true)
    }

}