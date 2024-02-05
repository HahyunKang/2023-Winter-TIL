package com.hahyeon.portfolio.presentation.dto

import com.hahyeon.portfolio.domain.entity.Introduction

data class IntroductionDto(
    val content : String
){
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )
}