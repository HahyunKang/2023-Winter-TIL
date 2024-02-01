package com.hahyeon.portfolio.admin.context.link.controller

import com.hahyeon.portfolio.admin.context.link.service.AdminLinkService
import com.hahyeon.portfolio.admin.data.DateFormElementDTO
import com.hahyeon.portfolio.admin.data.FormElementDto
import com.hahyeon.portfolio.admin.data.SelectFormElementDTO
import com.hahyeon.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/link")
class AdminLinkViewController(
    private val adminlinkService: AdminLinkService
) {
    @GetMapping
    fun link(model : org.springframework.ui.Model):String{
        val formElements = listOf<FormElementDto>(
            TextFormElementDTO("name",2),
            TextFormElementDTO("content",8),
            SelectFormElementDTO("isActive",2, listOf(true.toString(),false.toString())),
        )
        model.addAttribute(formElements)

        val table =adminlinkService.getLinkTable()
        model.addAttribute("table",table)
        model.addAttribute("detailTable",null)

        val pageAttributes = mutableMapOf<String,Any>(
            Pair("menuName","Index"),
            Pair("pageName",table.name),
            Pair("editable",true),
            Pair("deletable",false),
            Pair("hasDetails",false),
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}