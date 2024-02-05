package com.hahyeon.portfolio.presentation.service

import com.hahyeon.portfolio.domain.entity.Introduction
import com.hahyeon.portfolio.presentation.repository.PresentationRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest{

    @InjectMocks
    lateinit var presentationService: PresentationService

    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    fun testGetIntroductions(){
        //given
        val introductions = mutableListOf<Introduction>()
        for (i in 1..DATA_SIZE){
            val introduction = Introduction(content = "${i}", isActive = i % 2 == 0)
            introductions.add(introduction)
        }
        val activeIntroductions = introductions.filter { it.isActive }

        //when
        Mockito.`when`(presentationRepository.getActiveIntroduction())
            .thenReturn(activeIntroductions)

        val introductionDtos = presentationService.getIntroductions()

        //then
        Assertions.assertThat(introductionDtos).hasSize(DATA_SIZE/2)
        for (introductionDTO in introductionDtos){
            assertThat(introductionDTO.content.toInt()).isEven()
        }
    }
}