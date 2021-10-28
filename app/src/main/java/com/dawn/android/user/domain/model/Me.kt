package com.dawn.android.user.domain.model

import java.time.LocalDate

data class Me(
    val id: UserId,
    val userName: String,
    val email: String,
    val password: String,
    val imageUrl: String,
    val displayName: String,
    val dateOfBirth: LocalDate,
    val sex: Sex,
)
