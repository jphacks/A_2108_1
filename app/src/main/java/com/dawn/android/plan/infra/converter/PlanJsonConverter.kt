package com.dawn.android.plan.infra.converter

import com.dawn.android.plan.domain.model.Address
import com.dawn.android.plan.domain.model.Category
import com.dawn.android.plan.domain.model.CategoryId
import com.dawn.android.plan.domain.model.Condition
import com.dawn.android.plan.domain.model.ConditionId
import com.dawn.android.plan.domain.model.Day
import com.dawn.android.user.domain.model.Place
import com.dawn.android.plan.domain.model.PlaceId
import com.dawn.android.plan.domain.model.Plan
import com.dawn.android.plan.domain.model.PlanDetail
import com.dawn.android.plan.domain.model.PlanId
import com.dawn.android.plan.domain.model.PlanSchedule
import com.dawn.android.plan.domain.model.Season
import com.dawn.android.plan.domain.model.SeasonId
import com.dawn.android.plan.domain.model.TimeSpan
import com.dawn.android.plan.domain.model.TimeSpanId
import com.dawn.android.plan.infra.api.json.AddressJson
import com.dawn.android.plan.infra.api.json.CategoryJson
import com.dawn.android.plan.infra.api.json.ConditionJson
import com.dawn.android.plan.infra.api.json.DayJson
import com.dawn.android.user.infra.api.json.PlaceJson
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
            seasons = json.season.map { convertToDomainModel(it) },
            timeSpans = json.timeSpan.map { convertToDomainModel(it) },
            categories = json.category.map { convertToDomainModel(it) },
        )
    }

    fun convertToDomainModel(json: AddressJson): Address {
        return Address(
            plusCode = json.plusCode,
        )
    }

    fun convertToDomainModel(json: DayJson): Day {
        val schedules = (json.headings + json.schedule)
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
                            address = scheduleJson.address?.let { convertToDomainModel(it) },
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
            days = json.days.map { convertToDomainModel(it) },
            condition = convertToDomainModel(json.conditions),
            createdAt = Instant.parse(json.createdAt),
        )
    }

    fun convertToDomainModel(json: PlanJson): Plan {
        return Plan(
            id = PlanId(json.planId),
            title = json.title,
            description = json.description,
            imageUrl = json.imageUrl,
            creator = UserJsonConverter.convertToDomainModel(json.creator),
            createdAt = Instant.parse(json.createdAt),
        )
    }
}
