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

    val email: String?
    val password: String?
    val nickname: String?
    val userId: String?
    val area: Area?
    val prefecture: Prefecture?
    val place: Place?
    val biography: String?
    val contact: Contact?

    object Init : EmailRegistrationState {
        override val email: String? = null
        override val password: String? = null
        override val nickname: String? = null
        override val userId: String? = null
        override val area: Area? = null
        override val prefecture: Prefecture? = null
        override val place: Place? = null
        override val biography: String? = null
        override val contact: Contact? = null
    }

    data class EmailPassword(
        override val email: String,
        override val password: String,
    ) : EmailRegistrationState {
        override val nickname: String? = null
        override val userId: String? = null
        override val area: Area? = null
        override val prefecture: Prefecture? = null
        override val place: Place? = null
        override val biography: String? = null
        override val contact: Contact? = null

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
        override val email: String,
        override val password: String,
        override val nickname: String,
        override val userId: String,
    ) : EmailRegistrationState {
        override val area: Area? = null
        override val prefecture: Prefecture? = null
        override val place: Place? = null
        override val biography: String? = null
        override val contact: Contact? = null

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
        override val email: String,
        override val password: String,
        override val nickname: String,
        override val userId: String,
        override val area: Area,
    ) : EmailRegistrationState {
        override val prefecture: Prefecture? = null
        override val place: Place? = null
        override val biography: String? = null
        override val contact: Contact? = null

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
        override val email: String,
        override val password: String,
        override val nickname: String,
        override val userId: String,
        override val area: Area,
        override val prefecture: Prefecture,
    ) : EmailRegistrationState {
        override val place: Place? = null
        override val biography: String? = null
        override val contact: Contact? = null

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
        override val email: String,
        override val password: String,
        override val nickname: String,
        override val userId: String,
        override val area: Area,
        override val prefecture: Prefecture,
        override val place: Place,
    ) : EmailRegistrationState {
        override val biography: String? = null
        override val contact: Contact? = null

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
        override val email: String,
        override val password: String,
        override val nickname: String,
        override val userId: String,
        override val area: Area,
        override val prefecture: Prefecture,
        override val place: Place,
        override val biography: String,
    ) : EmailRegistrationState {
        override val contact: Contact? = null

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
        override val email: String,
        override val password: String,
        override val nickname: String,
        override val userId: String,
        override val area: Area,
        override val prefecture: Prefecture,
        override val place: Place,
        override val biography: String,
        override val contact: Contact,
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
                contact = contact.copy(
                    biography = biography,
                ),
                place = place,
            )
        }
    }
}
