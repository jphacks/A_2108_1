package com.dawn.android.plan.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class TimeSpanJson(
    val id: Long,
    val text: String,
)
