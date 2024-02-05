package com.hahyeon.portfolio.admin.context.link.service

import com.hahyeon.portfolio.admin.data.TableDto
import com.hahyeon.portfolio.domain.entity.Link
import com.hahyeon.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {
    fun getLinkTable() : TableDto{
        val classInfo = Link ::class
        val entities = linkRepository.findAll()

        return TableDto.from(classInfo,entities)
    }
}