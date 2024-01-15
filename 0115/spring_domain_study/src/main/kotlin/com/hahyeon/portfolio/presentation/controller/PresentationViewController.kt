package com.hahyeon.portfolio.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

//html 파일 return
@Controller
class PresentationViewController {

    @GetMapping("/test")
    fun test() : String{
        return "test"
    }
}