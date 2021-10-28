package com.dawn.android.user.infra.converter

import com.dawn.android.common.ui.toRFC3339
import com.dawn.android.plan.domain.model.PlaceId
import com.dawn.android.user.domain.model.Contact
import com.dawn.android.user.domain.model.Creator
import com.dawn.android.user.domain.model.CreatorId
import com.dawn.android.user.domain.model.Job
import com.dawn.android.user.domain.model.JobId
import com.dawn.android.user.domain.model.Place
import com.dawn.android.user.domain.model.Sex
import com.dawn.android.user.domain.model.Token
import com.dawn.android.user.domain.model.UserRegistration
import com.dawn.android.user.infra.api.json.ContactJson
import com.dawn.android.user.infra.api.json.JobJson
import com.dawn.android.user.infra.api.json.CreatorUserJson
import com.dawn.android.user.infra.api.json.PlaceJson
import com.dawn.android.user.infra.api.json.TokenJson
import com.dawn.android.user.infra.api.json.UserRegistrationJson
import java.time.Instant

object UserJsonConverter {
    fun convertToDomainModel(json: JobJson): Job {
        return Job(
            id = JobId(json.id),
            jobName = json.jobName,
            dateOfFirstJob = Instant.parse(json.dateOfFirstJob),
        )
    }

    fun convertToDomainModel(json: CreatorUserJson): Creator {
        return Creator(
            id = CreatorId(json.creator.id),
            imageUrl = json.imageUrl,
            displayName = json.creator.realName,
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

    fun convertToDomainModel(json: PlaceJson): Place {
        return Place(
            id = PlaceId(json.id),
            area = json.area,
            prefecture = json.area,
            city = json.city,
            name = json.name,
        )
    }

    fun convertToDomainModel(json: TokenJson): Token {
        return Token(json.token)
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

    fun convertToJson(model: Place): PlaceJson {
        return PlaceJson(
            id = model.id.value,
            area = model.area,
            prefecture = model.prefecture,
            city = model.city,
            name = model.name,
        )
    }

    fun convertToJson(model: UserRegistration): UserRegistrationJson {
        return UserRegistrationJson(
            userName = model.userName,
            email = model.email,
            password = model.password,
            image = model.imageUrl,
            displayName = model.displayName,
            dateOfBirth = model.dateOfBirth.toRFC3339(),
            sex = when (model.sex) {
                Sex.Male -> 0
                Sex.Female -> 1
                Sex.Other -> 2
            },
            contacts = convertToJson(model.contact),
            address = convertToJson(model.place),
        )
    }
}
