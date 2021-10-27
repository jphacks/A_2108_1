package com.dawn.android.plan.infra.converter

import com.dawn.android.plan.domain.model.Category
import com.dawn.android.plan.domain.model.CategoryId
import com.dawn.android.plan.domain.model.Condition
import com.dawn.android.plan.domain.model.ConditionId
import com.dawn.android.plan.domain.model.Day
import com.dawn.android.plan.domain.model.Place
import com.dawn.android.plan.domain.model.PlaceId
import com.dawn.android.plan.domain.model.Plan
import com.dawn.android.plan.domain.model.PlanDetail
import com.dawn.android.plan.domain.model.PlanId
import com.dawn.android.plan.domain.model.PlanSchedule
import com.dawn.android.plan.domain.model.Season
import com.dawn.android.plan.domain.model.SeasonId
import com.dawn.android.plan.domain.model.TimeSpan
import com.dawn.android.plan.domain.model.TimeSpanId
import com.dawn.android.plan.infra.api.json.CategoryJson
import com.dawn.android.plan.infra.api.json.ConditionJson
import com.dawn.android.plan.infra.api.json.DayJson
import com.dawn.android.plan.infra.api.json.PlaceJson
import com.dawn.android.plan.infra.api.json.PlanDetailJson
import com.dawn.android.plan.infra.api.json.PlanJson
import com.dawn.android.plan.infra.api.json.PlanScheduleJson
import com.dawn.android.plan.infra.api.json.SeasonJson
import com.dawn.android.plan.infra.api.json.TimeSpanJson
import com.dawn.android.user.infra.converter.UserJsonConverter
import java.time.LocalTime

object PlanConverter {
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

    fun convertToDomainModel(json: PlaceJson): Place {
        return Place(
            id = PlaceId(json.id),
            area = json.area,
            prefecture = json.area,
            city = json.city,
        )
    }

    fun convertToDomainModel(json: DayJson): Day {
        val schedules = (json.headings + json.schedule)
            .sortedBy { it.order }
            .map {
                when (it) {
                    is PlanScheduleJson.Heading -> {
                        PlanSchedule.Heading(it.text)
                    }
                    is PlanScheduleJson.Section -> {
                        PlanSchedule.Section(
                            title = it.title,
                            description = it.description,
                            startTime = LocalTime.of(it.startTime / 60, it.startTime % 60),
                            endTime = LocalTime.of(it.endTime / 60, it.endTime % 60),
                            place = convertToDomainModel(it.place),
                            hpLink = it.hpLink,
                            reservationLink = it.reservationLink,
                        )
                    }
                }
            }
        return Day(
            schedules = schedules,
        )
    }

    fun convertToDomainModel(json: PlanDetailJson): PlanDetail {
        return PlanDetail(
            id = PlanId(json.planId),
            title = json.title,
            description = json.description,
            imageUrl = json.imageUrl,
            creator = UserJsonConverter.convertToDomainModel(json.creator),
            days = json.days.map { convertToDomainModel(it) },
            condition = convertToDomainModel(json.conditions),
        )
    }

    fun convertToDomainModel(json: PlanJson): Plan {
        return Plan(
            id = PlanId(json.planId),
            title = json.title,
            description = json.description,
            creator = UserJsonConverter.convertToDomainModel(json.creator),
        )
    }
}
