package com.hahyeon.portfolio.admin.context.introduction.controller

import com.hahyeon.portfolio.admin.context.introduction.service.AdminIntroductionService
import com.hahyeon.portfolio.admin.data.*
import com.hahyeon.portfolio.domain.entity.Achievement
import com.hahyeon.portfolio.domain.entity.Introduction
import com.hahyeon.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/introduction")
class AdminIntroductionViewController(
    private val introductionService: AdminIntroductionService
) {

    @GetMapping
    fun introduction(model: org.springframework.ui.Model): String {
        val formElements = listOf<FormElementDto>(
            TextFormElementDTO("title", 10),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),
        )
        model.addAttribute(formElements)

        val table = introductionService.getIntroductionTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Index"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", false),
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}