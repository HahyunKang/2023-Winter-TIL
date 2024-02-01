package com.hahyeon.portfolio.admin.context.introduction.service

import com.hahyeon.portfolio.admin.data.TableDto
import com.hahyeon.portfolio.domain.entity.Achievement
import com.hahyeon.portfolio.domain.entity.Introduction
import com.hahyeon.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository

) {
    fun getIntroductionTable() : TableDto {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDto.from(classInfo,entities)
    }
}