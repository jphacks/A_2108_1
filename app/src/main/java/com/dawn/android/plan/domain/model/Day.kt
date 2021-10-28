package com.dawn.android.plan.domain.model

data class Day(
    val day: Int,
    val schedules: List<PlanSchedule>
)
