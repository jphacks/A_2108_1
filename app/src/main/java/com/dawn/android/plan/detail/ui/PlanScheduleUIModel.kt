package com.dawn.android.plan.detail.ui

import java.time.LocalTime

sealed interface PlanScheduleUIModel {
    data class Day(
        val day: Int,
    ) : PlanScheduleUIModel

    data class Heading(
        val text: String,
    ) : PlanScheduleUIModel

    data class Section(
        val title: String,
        val description: String,
        val startTime: LocalTime,
        val endTime: LocalTime,
    ) : PlanScheduleUIModel
}
