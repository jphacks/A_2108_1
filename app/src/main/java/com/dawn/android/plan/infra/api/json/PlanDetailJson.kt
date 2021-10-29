package com.dawn.android.plan.infra.api.json

import com.dawn.android.user.infra.api.json.CreatorUserJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanDetailJson(
    @SerialName("planID")
    val planId: Long,
    val title: String,
    val description: String,
    @SerialName("image")
    val imageUrl: String,
    val creatorUser: CreatorUserJson,
    val days: List<DayJson>?,
    val conditions: ConditionJson,
    val createdAt: String,
)
