package com.dawn.android.plan.infra.api.json

import com.dawn.android.user.infra.api.json.CreatorUserJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanJson(
    @SerialName("planID")
    val planId: Long,
    val title: String,
    val description: String,
    @SerialName("image")
    val imageUrl: String,
    @SerialName("creatorUser")
    val creator: CreatorUserJson,
    val createdAt: String,
)
