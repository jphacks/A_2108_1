package com.dawn.android.plan.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class CategoryJson(
    val id: Long,
    val text: String,
)
