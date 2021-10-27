package com.dawn.android.plan.infra.api.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed interface PlanScheduleJson {

    val order: Int

    @Serializable
    data class Heading(
        val id: Long,
        val text: String,
        override val order: Int
    ) : PlanScheduleJson

    @Serializable
    data class Section(
        val id: Long,
        val title: String,
        val description: String,
        val startTime: Int,
        @SerialName("EndTime")
        val endTime: Int,
        val place: PlaceJson,
        val hpLink: String,
        val reservationLink: String,
        override val order: Int,
    ) : PlanScheduleJson
}