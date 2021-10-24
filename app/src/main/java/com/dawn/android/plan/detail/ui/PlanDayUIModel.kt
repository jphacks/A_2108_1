package com.dawn.android.plan.detail.ui

data class PlanDayUIModel(
    val day: Int,
    val headings: List<PlanHeadingUIModel>,
    val schedule: List<PlanScheduleUIModel>,
)
