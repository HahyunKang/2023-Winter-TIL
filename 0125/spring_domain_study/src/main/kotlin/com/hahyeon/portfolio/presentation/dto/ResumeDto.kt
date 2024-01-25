package com.hahyeon.portfolio.presentation.dto

import com.hahyeon.portfolio.domain.entity.Achievement
import com.hahyeon.portfolio.domain.entity.Experience
import com.hahyeon.portfolio.domain.entity.Skill
import java.time.format.DateTimeFormatter

class ResumeDto(
    experiences: List<Experience>,
    achievements: List<Achievement>,
    skills : List<Skill>
){
    var experiences : List<ExperienceDto> = experiences.map {
        ExperienceDto(
            title = it.title,
            description = it.description,
            startYearMonth = "${it.startYear}.${it.startMonth}",
            endYearMonth = it.getEndYearMonth(),
            details =  it.details.filter { it.isActive }.map { it.content }
        )
    }

    var achievements : List<AchievementDto> = achievements.map {
        AchievementDto(
            title= it.title,
            description =  it.description,
            host= it.host,
            achievedDate = it.achievedDate?.format(DateTimeFormatter.ISO_LOCAL_DATE)
                ?.replace("-",".")
        )
    }

    var skills : List<SkillDto> = skills.map {SkillDto(it) }
}