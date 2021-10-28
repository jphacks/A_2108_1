package com.dawn.android.user.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class CreatorJson(
    val id: Long,
    val realName: String,
    val job: JobJson,
)
