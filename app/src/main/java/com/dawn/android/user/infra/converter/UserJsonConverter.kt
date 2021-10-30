package com.dawn.android.user.infra.converter

import com.dawn.android.common.ui.asRFC3339Instant
import com.dawn.android.common.ui.asRFC3339LocalDateTime
import com.dawn.android.plan.domain.model.PlaceId
import com.dawn.android.user.domain.model.Contact
import com.dawn.android.user.domain.model.CreatorId
import com.dawn.android.user.domain.model.Job
import com.dawn.android.user.domain.model.JobId
import com.dawn.android.place.domain.model.Place
import com.dawn.android.user.infra.api.json.ContactJson
import com.dawn.android.user.infra.api.json.JobJson
import com.dawn.android.user.infra.api.json.CreatorUserJson
import com.dawn.android.place.infra.api.json.PlaceJson
import com.dawn.android.user.domain.model.Creator
import com.dawn.android.user.domain.model.Me
import com.dawn.android.user.domain.model.OtherUser
import com.dawn.android.user.domain.model.Sex
import com.dawn.android.user.domain.model.UserId
import com.dawn.android.user.infra.api.json.UserJson

object UserJsonConverter {
    fun convertToDomainModel(json: JobJson): Job {
        return Job(
            id = JobId(json.id),
            jobName = json.jobName,
            dateOfFirstJob = json.dateOfFirstJob.asRFC3339Instant(),
        )
    }

    fun convertToDomainModel(json: CreatorUserJson): Creator {
        return OtherUser.TravelCreator(
            userId = UserId(json.id),
            userName = json.userName,
            imageUrl = json.imageUrl,
            displayName = json.displayName,
            contacts = convertToDomainModel(json.contacts),
            creatorId = CreatorId(json.creator.id),
            realName = json.creator.realName,
            job = convertToDomainModel(json.creator.job),
        )
    }

    fun convertToDomainModel(json: ContactJson): Contact {
        return Contact(
            hpLink = json.hpLink,
            instagramLink = json.instagramLink,
            twitterLink = json.twitterLink,
            facebookLink = json.facebookLink,
            tiktokLink = json.tiktokLink,
            biography = json.biography ?: "",
        )
    }

    fun convertToMeDomainModel(json: UserJson): Me {
        val creator = json.creator
        return if (creator != null) {
            Me.TravelCreator(
                userId = UserId(json.id),
                userName = json.userName,
                imageUrl = json.imageUrl,
                displayName = json.displayName,
                contacts = convertToDomainModel(json.contacts),
                email = json.email,
                dateOfBirth = json.dateOfBirth.asRFC3339LocalDateTime().toLocalDate(),
                sex = when (json.sex) {
                    0 -> Sex.Male
                    1 -> Sex.Female
                    2 -> Sex.Other
                    else -> Sex.Other
                },
                place = convertToDomainModel(json.address),
                creatorId = CreatorId(creator.id),
                realName = creator.realName,
                job = convertToDomainModel(creator.job),
            )
        } else {
            Me.Normal(
                userId = UserId(json.id),
                userName = json.userName,
                imageUrl = json.imageUrl,
                displayName = json.displayName,
                contacts = convertToDomainModel(json.contacts),
                email = json.email,
                dateOfBirth = json.dateOfBirth.asRFC3339LocalDateTime().toLocalDate(),
                sex = when (json.sex) {
                    0 -> Sex.Male
                    1 -> Sex.Female
                    2 -> Sex.Other
                    else -> Sex.Other
                },
                place = convertToDomainModel(json.address),
            )
        }
    }

    fun convertToDomainModel(json: PlaceJson): Place {
        return Place(
            id = PlaceId(json.id),
            area = json.area,
            prefecture = json.area,
            city = json.city,
            name = json.name,
        )
    }

    fun convertToJson(model: Contact): ContactJson {
        return ContactJson(
            id = 0,
            hpLink = model.hpLink,
            instagramLink = model.instagramLink,
            twitterLink = model.twitterLink,
            facebookLink = model.facebookLink,
            tiktokLink = model.tiktokLink,
            biography = model.biography,
        )
    }
}
