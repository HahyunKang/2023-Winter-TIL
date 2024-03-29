package com.hahyeon.portfolio.admin.context.skill.controller

import com.hahyeon.portfolio.admin.context.skill.service.AdminSkillService
import com.hahyeon.portfolio.admin.data.FormElementDto
import com.hahyeon.portfolio.admin.data.SelectFormElementDTO
import com.hahyeon.portfolio.admin.data.TextFormElementDTO
import com.hahyeon.portfolio.domain.constant.SkillType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/skill")
class AdminSkillViewController(
    private val skillService: AdminSkillService
) {

    @GetMapping
    fun skill(model : org.springframework.ui.Model):String{
        val formElements = listOf<FormElementDto>(
            TextFormElementDTO("name",2),
            SelectFormElementDTO("type",2,SkillType.values().map{it.name}.toList()),
            SelectFormElementDTO("isActive",2, listOf(true.toString(),false.toString())),
        )
        model.addAttribute(formElements)

        val table =skillService.getSkillTable()
        model.addAttribute("table",table)
        model.addAttribute("detailTable",null)

        val pageAttributes = mutableMapOf<String,Any>(
            Pair("menuName","Resume"),
            Pair("pageName",table.name),
            Pair("editable",true),
            Pair("deletable",false),
            Pair("hasDetails",false),
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}