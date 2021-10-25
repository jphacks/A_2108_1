package com.dawn.android.plan.infra.api.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScheduleJson(
    val id: Long,
    val title: String,
    val description: String,
    val startTime: String,
    @SerialName("EndTime")
    val endTime: String,
    val place: PlaceJson,
    val hpLink: String,
    val reservationLink: String,
    val order: Int,
)
