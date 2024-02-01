package com.hahyeon.portfolio.presentation.controller

import com.hahyeon.portfolio.presentation.dto.IntroductionDto
import com.hahyeon.portfolio.presentation.dto.LinkDto
import com.hahyeon.portfolio.presentation.dto.ProjectDto
import com.hahyeon.portfolio.presentation.dto.ResumeDto
import com.hahyeon.portfolio.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController(
    private val presentationService: PresentationService
) {

    //return한 body를 그대로 넣어준다.

    @GetMapping("/test")
    fun test() : String {
        return "OK"
    }

    @GetMapping("v1/introductions")
    fun getIntroductions() : List<IntroductionDto>{
        return presentationService.getIntroductions()
    }

    @GetMapping("v1/links")
    fun getLinks() : List<LinkDto>{
        return presentationService.getLinks()
    }

    @GetMapping("v1/resume")
    fun getResume() :ResumeDto{
        return presentationService.getResume()
    }

    @GetMapping("v1/projects")
    fun getProjects() :List<ProjectDto>{
        return presentationService.getProjects()
    }






}