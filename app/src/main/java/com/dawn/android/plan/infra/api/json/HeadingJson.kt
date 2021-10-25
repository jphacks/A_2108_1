package com.dawn.android.plan.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class HeadingJson(
    val id: Long,
    val text: String,
    val order: Int,
)
