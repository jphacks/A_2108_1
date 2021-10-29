package com.dawn.android.plan.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class DayJson(
    val nthDay: Int,
    val headings: List<PlanScheduleJson.Heading>?,
    val schedule: List<PlanScheduleJson.Section>?,
)
