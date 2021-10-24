package com.dawn.android.plan.detail.ui

import java.time.LocalTime

data class PlanScheduleUIModel(
    val title: String,
    val description: String,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val order: Int,
)
