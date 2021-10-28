package com.dawn.android.user.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class JobJson(
    val id: Long,
    val jobName: String,
    val dateOfFirstJob: String,
)
