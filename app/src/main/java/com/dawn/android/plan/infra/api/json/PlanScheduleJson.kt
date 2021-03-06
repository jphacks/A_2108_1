package com.dawn.android.plan.infra.api.json

import com.dawn.android.place.infra.api.json.AddressJson
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
        val endTime: Int,
        val address: AddressJson?,
        val hpLink: String?,
        val reservationLink: String?,
        override val order: Int,
    ) : PlanScheduleJson
}