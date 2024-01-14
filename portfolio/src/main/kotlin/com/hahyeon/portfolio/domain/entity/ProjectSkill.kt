package com.hahyeon.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectSkill(project: Project, skill: Skill) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_skill_id")
    //테이블 명은 _id, 코틀린 entity는 id -> 직관적으로 변수 사용 가능
    var id: Long? = null

    @ManyToOne(targetEntity = Project::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    var project :  Project = project

    @ManyToOne(targetEntity = Skill::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    var skill : Skill = skill

}