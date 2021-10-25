package com.dawn.android.user.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class CreatorJson(
    val id: Long,
    val image: String,
    val displayName: String,
    val job: JobJson,
)
