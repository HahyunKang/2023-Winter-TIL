package com.hahyeon.portfolio.presentation.dto

import com.hahyeon.portfolio.domain.entity.ProjectDetail

data class ProjectDetailDto(
    val content : String,
    val url : String?
){
    constructor(projectDetail: ProjectDetail) : this(
        content = projectDetail.content,
        url = projectDetail.url
    )
    
}