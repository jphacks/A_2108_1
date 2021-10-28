package com.dawn.android.plan.infra.api.json

import com.dawn.android.user.infra.api.json.MaskedUserJson
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
    val creator: MaskedUserJson,
    val createdAt: String,
)
