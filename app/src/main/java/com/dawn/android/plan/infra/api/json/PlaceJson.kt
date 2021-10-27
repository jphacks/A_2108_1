package com.dawn.android.plan.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class PlaceJson(
    val id: Long,
    val area: Int,
    val prefecture: Int,
    val city: Int,
)
