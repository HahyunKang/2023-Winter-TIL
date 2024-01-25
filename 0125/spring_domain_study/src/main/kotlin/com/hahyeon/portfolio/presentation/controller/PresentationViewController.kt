package com.hahyeon.portfolio.presentation.controller

import ch.qos.logback.core.model.Model
import com.hahyeon.portfolio.domain.constant.SkillType
import com.hahyeon.portfolio.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

//html 파일 return
@Controller
class PresentationViewController(
    private val presentationService: PresentationService
) {

    @GetMapping("/test")
    fun test() : String{
        return "test"
    }

    @GetMapping("/")
    fun index(model : org.springframework.ui.Model):String{

        val introductions = presentationService.getIntroductions()
        model.addAttribute("introductions",introductions)

        val links = presentationService.getLinks()
        model.addAttribute("links",links)

        return "presentation/index"
    }

    @GetMapping("/resume")
    fun resume(model:org.springframework.ui.Model) :String {
        val resume = presentationService.getResume()
        model.addAttribute("resume",resume)
        model.addAttribute("skillTypes",SkillType.values())

        return "presentation/resume"

    }

    @GetMapping("/projects")
    fun projects(model:org.springframework.ui.Model) :String {
        val projects = presentationService.getProjects()
        model.addAttribute("projects",projects)

        return "presentation/projects"

    }



}