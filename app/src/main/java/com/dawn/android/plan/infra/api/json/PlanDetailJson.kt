package com.dawn.android.plan.infra.api.json

import com.dawn.android.user.infra.api.json.CreatorJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanDetailJson(
    val planId: Long,
    val title: String,
    val description: String,
    @SerialName("image")
    val imageUrl: String,
    val creator: CreatorJson,
    val days: List<DayJson>,
    val conditions: ConditionJson,
)
