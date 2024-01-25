package com.hahyeon.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Project(
    name : String,
    description : String,
    startYear : Int,
    startMonth : Int,
    endYear:  Int?,
    endMonth : Int?,
    isActive : Boolean
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_id")
    //테이블 명은 _id, 코틀린 entity는 id -> 직관적으로 변수 사용 가능
    var id: Long? = null

    var name : String = name

    var description : String = description

    var startYear : Int = startYear

    var startMonth : Int = startMonth

    var endYear : Int? = endYear

    var endMonth : Int? = endMonth

    var isActive : Boolean = isActive

    fun getEndYearMonth() : String{
        if(endYear == null || endMonth == null){
            return "Present"
        }

        return "${endYear}.${endMonth}"
    }

    fun update(
        name : String, description : String, startYear : Int, startMonth : Int, endYear:  Int?, endMonth : Int?, isActive : Boolean
    ){
        this.name = name
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }


    fun addDetails(details : MutableList<ProjectDetail>?){
        if(details != null){
            this.details.addAll(details)
        }
    }

    //영속성 컨텍스트에 적용되는 변화가 자식에게도 적용(cascade)
    @OneToMany(targetEntity = ProjectDetail::class, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "project_id")
    var details : MutableList<ProjectDetail> = mutableListOf()


    //ProjectSkill안에 있는 project 변수에 의해 mapping된다. 양방향에서 적용
    @OneToMany(mappedBy = "project")
    var skills : MutableList<ProjectSkill> = mutableListOf()


}