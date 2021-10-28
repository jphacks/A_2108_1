package com.dawn.android.user.domain.model

import java.time.Instant

data class Job(
    val id: JobId,
    val jobName: String,
    val dateOfFirstJob: Instant,
)
