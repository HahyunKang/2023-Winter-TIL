package com.hahyeon.portfolio.presentation.service

import com.hahyeon.portfolio.presentation.dto.IntroductionDto
import com.hahyeon.portfolio.presentation.dto.LinkDto
import com.hahyeon.portfolio.presentation.dto.ProjectDto
import com.hahyeon.portfolio.presentation.dto.ResumeDto
import com.hahyeon.portfolio.presentation.repository.PresentationRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PresentationService(
    private val presentationRepository: PresentationRepository
) {

    //한 개의 트랜잭션으로 묶임.
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    fun getIntroductions(): List<IntroductionDto>{
        val introductions = presentationRepository.getActiveIntroduction()
        return introductions.map { IntroductionDto(it) }
    }


    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    fun getLinks() : List<LinkDto> {
        val links = presentationRepository.getActiveLinks()
        return links.map { LinkDto(it) }
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    fun getProjects() : List<ProjectDto>{
        val projects = presentationRepository.getActiveProjects()

        return projects.map{ProjectDto(it)}
    }

}