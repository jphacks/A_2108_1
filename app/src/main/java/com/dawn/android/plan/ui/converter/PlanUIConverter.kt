package com.dawn.android.plan.ui.converter

import com.dawn.android.plan.detail.ui.PlanDetailUIModel
import com.dawn.android.plan.detail.ui.PlanScheduleUIModel
import com.dawn.android.plan.domain.model.Plan
import com.dawn.android.plan.domain.model.PlanDetail
import com.dawn.android.plan.domain.model.PlanSchedule
import com.dawn.android.plan.timeline.ui.TimelineItemUIModel
import java.time.Duration
import java.time.Instant

object PlanUIConverter {
    fun convertToUIModel(model: Plan): TimelineItemUIModel {
        return TimelineItemUIModel(
            id = model.id.value,
            title = model.title,
            planImageUrl = model.imageUrl,
            bookmarks = 0,
            creatorName = model.creator.displayName,
            creatorProfileImageUrl = model.creator.imageUrl,
            creatorJob = model.creator.job.jobName,
            creatorJobExperienceYears = toJobExperienceYears(model.creator.job.dateOfFirstJob),
            createdAt = model.createdAt,
        )
    }

    fun convertToUIModel(model: PlanDetail): PlanDetailUIModel {
        var number = 0
        val schedule = model.days.flatMap { day ->
            listOf(PlanScheduleUIModel.Day(day.day)) + day.schedules.map {
                when (it) {
                    is PlanSchedule.Heading -> {
                        PlanScheduleUIModel.Heading(it.text)
                    }
                    is PlanSchedule.Section -> {
                        number++
                        PlanScheduleUIModel.Section(
                            number = number,
                            title = it.title,
                            description = it.description,
                            startTime = it.startTime,
                            endTime = it.endTime,
                        )
                    }
                }
            }
        }
        return PlanDetailUIModel(
            title = model.title,
            description = model.description,
            imageUrl = model.imageUrl,
            bookmarkCount = 0,
            bookmarked = false,
            creatorName = model.creator.displayName,
            creatorProfileImageUrl = model.creator.imageUrl,
            schedule = schedule,
            createdAt = model.createdAt,
            places = listOf(),
            categories = model.condition.categories.map { it.text },
            seasons = model.condition.seasons.map { it.text },
            timeSpans = model.condition.timeSpans.map { it.text },
            cost = model.condition.estimatedCost,
        )
    }

    private fun toJobExperienceYears(dateOfFirstJob: Instant): Int {
        val now = Instant.now()
        val duration = Duration.between(dateOfFirstJob, now)
        return duration.toDays().toInt() / 365
    }
}