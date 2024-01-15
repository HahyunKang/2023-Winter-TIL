package com.hahyeon.portfolio.presentation.dto

import com.hahyeon.portfolio.domain.entity.Link

class LinkDto(
    val name : String,
    val content : String
) {
    constructor(link : Link) : this(
        name = link.name.lowercase(),
        content = link.content
    )
}