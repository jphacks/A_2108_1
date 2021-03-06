package com.dawn.android.plan.infra.converter

import com.dawn.android.common.ui.asRFC3339Instant
import com.dawn.android.common.ui.asRFC3339LocalDateTime
import com.dawn.android.plan.domain.model.Category
import com.dawn.android.plan.domain.model.CategoryId
import com.dawn.android.plan.domain.model.Condition
import com.dawn.android.plan.domain.model.ConditionId
import com.dawn.android.plan.domain.model.Day
import com.dawn.android.plan.domain.model.Plan
import com.dawn.android.plan.domain.model.PlanDetail
import com.dawn.android.plan.domain.model.PlanId
import com.dawn.android.plan.domain.model.PlanSchedule
import com.dawn.android.plan.domain.model.Season
import com.dawn.android.plan.domain.model.SeasonId
import com.dawn.android.plan.domain.model.TimeSpan
import com.dawn.android.plan.domain.model.TimeSpanId
import com.dawn.android.place.infra.converter.PlaceJsonConverter
import com.dawn.android.plan.infra.api.json.CategoryJson
import com.dawn.android.plan.infra.api.json.ConditionJson
import com.dawn.android.plan.infra.api.json.DayJson
import com.dawn.android.plan.infra.api.json.PlanDetailJson
import com.dawn.android.plan.infra.api.json.PlanJson
import com.dawn.android.plan.infra.api.json.PlanScheduleJson
import com.dawn.android.plan.infra.api.json.SeasonJson
import com.dawn.android.plan.infra.api.json.TimeSpanJson
import com.dawn.android.user.infra.converter.UserJsonConverter
import java.time.Instant
import java.time.LocalTime

object PlanJsonConverter {
    fun convertToDomainModel(json: SeasonJson): Season {
        return Season(
            id = SeasonId(json.id),
            text = json.text,
        )
    }

    fun convertToDomainModel(json: TimeSpanJson): TimeSpan {
        return TimeSpan(
            id = TimeSpanId(json.id),
            text = json.text,
        )
    }

    fun convertToDomainModel(json: CategoryJson): Category {
        return Category(
            id = CategoryId(json.id),
            text = json.text,
        )
    }

    fun convertToDomainModel(json: ConditionJson): Condition {
        return Condition(
            id = ConditionId(json.id),
            seasons = json.season?.map { convertToDomainModel(it) } ?: listOf(),
            timeSpans = json.timeSpan?.map { convertToDomainModel(it) } ?: listOf(),
            categories = json.category?.map { convertToDomainModel(it) } ?: listOf(),
            places = json.place?.map { UserJsonConverter.convertToDomainModel(it) } ?: listOf(),
            estimatedCost = json.estimatedCost,
        )
    }

    fun convertToDomainModel(json: DayJson): Day {
        val headingsJson = json.headings ?: listOf()
        val schedulesJson = json.schedule ?: listOf()
        val schedules = (headingsJson + schedulesJson)
            .sortedBy { it.order }
            .map { scheduleJson ->
                when (scheduleJson) {
                    is PlanScheduleJson.Heading -> {
                        PlanSchedule.Heading(scheduleJson.text)
                    }
                    is PlanScheduleJson.Section -> {
                        PlanSchedule.Section(
                            title = scheduleJson.title,
                            description = scheduleJson.description,
                            startTime = LocalTime.of(scheduleJson.startTime / 60, scheduleJson.startTime % 60),
                            endTime = LocalTime.of(scheduleJson.endTime / 60, scheduleJson.endTime % 60),
                            address = scheduleJson.address?.let { PlaceJsonConverter.convertToDomainModel(it) },
                            hpLink = scheduleJson.hpLink,
                            reservationLink = scheduleJson.reservationLink,
                        )
                    }
                }
            }
        return Day(
            day = json.nthDay,
            schedules = schedules,
        )
    }

    fun convertToDomainModel(json: PlanDetailJson): PlanDetail {
        return PlanDetail(
            id = PlanId(json.planId),
            title = json.title,
            description = json.description,
            imageUrl = json.imageUrl,
            creator = UserJsonConverter.convertToDomainModel(json.creatorUser),
            days = json.days?.map { convertToDomainModel(it) } ?: listOf(),
            condition = convertToDomainModel(json.conditions),
            createdAt = json.createdAt.asRFC3339Instant(),
        )
    }

    fun convertToDomainModel(json: PlanJson): Plan {
        return Plan(
            id = PlanId(json.planId),
            title = json.title,
            description = json.description,
            imageUrl = json.imageUrl,
            creator = UserJsonConverter.convertToDomainModel(json.creator),
            createdAt = json.createdAt.asRFC3339Instant(),
        )
    }
}
