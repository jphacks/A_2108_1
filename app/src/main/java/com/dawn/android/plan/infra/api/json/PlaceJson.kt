package com.dawn.android.plan.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class PlaceJson(
    val id: Long,
    val area: String,
    val prefecture: String?,
    val city: String?,
)
