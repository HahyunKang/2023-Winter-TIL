package com.hahyeon.portfolio.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController {

    //return한 body를 그대로 넣어준다.

    @GetMapping("/test")
    fun test() : String {
        return "OK"
    }


}