package com.dawn.android.user.infra.api.json

data class UserRegistrationJson(
    val id: Long,
    val userName: String,
    val email: String,
    val password: String,
    val imageUrl: String,
    val displayName: String,
    val dateOfBirth: String,
    val sex: Int,
    val contact: ContactJson,
    val place: PlaceJson,
)
