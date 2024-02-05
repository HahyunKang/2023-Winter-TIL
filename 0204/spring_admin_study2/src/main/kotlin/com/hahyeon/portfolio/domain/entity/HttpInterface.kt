package com.hahyeon.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEntity() {
    //request에 대한 정보를 담아 오면, 클라이언트 정보를 꺼내 온다

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="http_interface_id")
    //테이블 명은 _id, 코틀린 entity는 id -> 직관적으로 변수 사용 가능
    var id: Long? = null

    var cookies : String? = httpServletRequest.cookies
         ?.map {
                "${ it.name }:${it.value}"
            }?.toString()

    var referer : String? = httpServletRequest.getHeader("referer")

    var localAddr : String ? = httpServletRequest.localAddr

    var remoteAddr : String ? = httpServletRequest.remoteAddr

    var remoteHost : String ? = httpServletRequest.remoteHost

    var requestUri : String? = httpServletRequest.requestURI

    //브라우저 정보
    var userAgent : String? = httpServletRequest.getHeader("userAgent")

}