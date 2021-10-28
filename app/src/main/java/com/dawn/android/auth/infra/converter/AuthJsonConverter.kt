package com.dawn.android.auth.infra.converter

import com.dawn.android.auth.domain.model.Token
import com.dawn.android.auth.domain.model.UserRegistration
import com.dawn.android.common.ui.toRFC3339
import com.dawn.android.user.domain.model.Sex
import com.dawn.android.auth.infra.api.json.TokenJson
import com.dawn.android.auth.infra.api.json.UserRegistrationJson
import com.dawn.android.user.infra.converter.UserJsonConverter

object AuthJsonConverter {
    fun convertToDomainModel(json: TokenJson): Token {
        return Token(json.token)
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
            contacts = UserJsonConverter.convertToJson(model.contact),
            address = UserJsonConverter.convertToJson(model.place),
        )
    }
}
