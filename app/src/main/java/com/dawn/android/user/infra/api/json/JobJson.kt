package com.dawn.android.user.infra.api.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobJson(
    val id: Long,
    @SerialName("jobname")
    val jobName: String,
    @SerialName("dateoffirstjob")
    val dateOfFirstJob: String,
)
