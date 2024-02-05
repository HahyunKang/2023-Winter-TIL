package com.hahyeon.portfolio.admin.interceptor

data class MenuDto(
    val name: String,
    val pages: List<PageDto>
) {
}