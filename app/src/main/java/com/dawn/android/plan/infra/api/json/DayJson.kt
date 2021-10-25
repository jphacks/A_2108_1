package com.dawn.android.plan.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class DayJson(
    val headings: List<HeadingJson>,
    val schedule: List<ScheduleJson>,
)
