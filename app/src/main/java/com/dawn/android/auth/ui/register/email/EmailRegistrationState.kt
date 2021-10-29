package com.dawn.android.auth.ui.register.email

import com.dawn.android.auth.domain.model.UserRegistration
import com.dawn.android.plan.domain.model.PlaceId
import com.dawn.android.place.domain.model.Area
import com.dawn.android.place.domain.model.City
import com.dawn.android.user.domain.model.Contact
import com.dawn.android.place.domain.model.Place
import com.dawn.android.place.domain.model.Prefecture
import com.dawn.android.user.domain.model.Sex
import java.time.LocalDate

sealed interface EmailRegistrationState {
    object Init : EmailRegistrationState

    data class EmailPassword(
        val email: String,
        val password: String,
    ) : EmailRegistrationState {
        fun next(
            nickname: String,
            userId: String,
        ): NicknameUserId {
            return NicknameUserId(
                email,
                password,
                nickname,
                userId,
            )
        }
    }

    data class NicknameUserId(
        val email: String,
        val password: String,
        val nickname: String,
        val userId: String,
    ) : EmailRegistrationState {
        fun next(
            area: Area,
        ): AddressArea {
            return AddressArea(
                email,
                password,
                nickname,
                userId,
                area,
            )
        }
    }

    data class AddressArea(
        val email: String,
        val password: String,
        val nickname: String,
        val userId: String,
        val area: Area,
    ) : EmailRegistrationState {
        fun next(
            prefecture: Prefecture,
        ): AddressPrefecture {
            return AddressPrefecture(
                email,
                password,
                nickname,
                userId,
                area,
                prefecture,
            )
        }
    }

    data class AddressPrefecture(
        val email: String,
        val password: String,
        val nickname: String,
        val userId: String,
        val area: Area,
        val prefecture: Prefecture,
    ) : EmailRegistrationState {
        fun next(
            city: City,
        ): AddressPlace {
            val place = Place(
                id = PlaceId(0),
                area = area.id,
                prefecture = prefecture.id,
                city = city.id,
                name = area.name + prefecture.name + city.name,
            )
            return AddressPlace(
                email,
                password,
                nickname,
                userId,
                area,
                prefecture,
                place,
            )
        }
    }

    data class AddressPlace(
        val email: String,
        val password: String,
        val nickname: String,
        val userId: String,
        val area: Area,
        val prefecture: Prefecture,
        val place: Place,
    ) : EmailRegistrationState {
        fun next(
            biography: String,
        ): Biography {
            return Biography(
                email,
                password,
                nickname,
                userId,
                area,
                prefecture,
                place,
                biography,
            )
        }
    }

    data class Biography(
        val email: String,
        val password: String,
        val nickname: String,
        val userId: String,
        val area: Area,
        val prefecture: Prefecture,
        val place: Place,
        val biography: String,
    ) : EmailRegistrationState {
        fun next(
            contact: Contact,
        ): Contacts {
            return Contacts(
                email,
                password,
                nickname,
                userId,
                area,
                prefecture,
                place,
                biography,
                contact,
            )
        }
    }

    data class Contacts(
        val email: String,
        val password: String,
        val nickname: String,
        val userId: String,
        val area: Area,
        val prefecture: Prefecture,
        val place: Place,
        val biography: String,
        val contact: Contact,
    ) : EmailRegistrationState {
        fun toUserRegistration(): UserRegistration {
            return UserRegistration(
                userName = userId,
                email = email,
                password = password,
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/7/7c/Profile_avatar_placeholder_large.png",
                displayName = nickname,
                dateOfBirth = LocalDate.of(2000, 1, 1), // TODO
                sex = Sex.Male, // TODO
                contact = contact,
                place = place,
            )
        }
    }
}
