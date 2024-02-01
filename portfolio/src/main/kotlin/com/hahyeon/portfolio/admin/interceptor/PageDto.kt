package com.hahyeon.portfolio.admin.interceptor

import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto

data class PageDto(
    val name : String,
    val url:String
) {
}