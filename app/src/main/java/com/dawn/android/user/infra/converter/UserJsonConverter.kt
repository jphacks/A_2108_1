package com.dawn.android.user.infra.converter

import com.dawn.android.user.domain.model.Creator
import com.dawn.android.user.domain.model.CreatorId
import com.dawn.android.user.domain.model.Job
import com.dawn.android.user.domain.model.JobId
import com.dawn.android.user.infra.api.json.CreatorJson
import com.dawn.android.user.infra.api.json.JobJson
import java.time.Instant

object UserJsonConverter {
    fun convertToDomainModel(json: JobJson): Job {
        return Job(
            id = JobId(json.id),
            jobName = json.jobName,
            dateOfFirstJob = Instant.parse(json.dateOfFirstJob),
        )
    }

    fun convertToDomainModel(json: CreatorJson): Creator {
        return Creator(
            id = CreatorId(json.id),
            imageUrl = json.image,
            displayName = json.displayName,
        )
    }
}
