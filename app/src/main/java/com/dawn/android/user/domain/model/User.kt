package com.dawn.android.user.domain.model

import com.dawn.android.place.domain.model.Place
import java.time.LocalDate

sealed interface MaskedUser {
    val userId: UserId
    val userName: String
    val imageUrl: String
    val displayName: String
    val contacts: Contact
}

sealed interface User : MaskedUser {
    val email: String
    val dateOfBirth: LocalDate
    val sex: Sex
    val place: Place
}

sealed interface Creator : MaskedUser {
    val creatorId: CreatorId
    val realName: String
    val job: Job
}

sealed interface Me : User {
    data class Normal(
        override val userId: UserId,
        override val userName: String,
        override val imageUrl: String,
        override val displayName: String,
        override val contacts: Contact,
        override val email: String,
        override val dateOfBirth: LocalDate,
        override val sex: Sex,
        override val place: Place,
    ) : Me

    data class TravelCreator(
        override val userId: UserId,
        override val userName: String,
        override val imageUrl: String,
        override val displayName: String,
        override val contacts: Contact,
        override val email: String,
        override val dateOfBirth: LocalDate,
        override val sex: Sex,
        override val place: Place,
        override val creatorId: CreatorId,
        override val realName: String,
        override val job: Job,
    ) : Me, Creator
}

sealed interface OtherUser {
    data class Normal(
        override val userId: UserId,
        override val userName: String,
        override val imageUrl: String,
        override val displayName: String,
        override val contacts: Contact,
    ) : MaskedUser

    data class TravelCreator(
        override val userId: UserId,
        override val userName: String,
        override val imageUrl: String,
        override val displayName: String,
        override val contacts: Contact,
        override val creatorId: CreatorId,
        override val realName: String,
        override val job: Job,
    ) : Creator
}
