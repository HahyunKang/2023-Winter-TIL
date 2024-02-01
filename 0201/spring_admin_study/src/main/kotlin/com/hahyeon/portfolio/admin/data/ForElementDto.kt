package com.hahyeon.portfolio.admin.data

abstract class FormElementDto(
    val name : String,
    val size : Int,
    val type : String
)

class TextFormElementDTO(
    name: String,
    size: Int
) : FormElementDto(name = name,size=size,type="text")

class DateFormElementDTO(
    name: String,
    size: Int
) : FormElementDto(name = name,size=size,type="date")

class SelectFormElementDTO(
    name: String,
    size: Int,
    options : List<Any>
) : FormElementDto(name = name,size=size,type="select"){
    val options : List<Any> = options
}