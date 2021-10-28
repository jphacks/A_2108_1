package com.dawn.android.plan.domain.model

import java.time.LocalTime

sealed interface PlanSchedule {
    data class Heading(
        val text: String,
    ) : PlanSchedule

    data class Section(
        val title: String,
        val description: String,
        val startTime: LocalTime,
        val endTime: LocalTime,
        val address: Address?,
        val hpLink: String?,
        val reservationLink: String?,
    ) : PlanSchedule
}