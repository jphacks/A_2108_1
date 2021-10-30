package com.dawn.android.auth.infra.api.json

import com.dawn.android.user.infra.api.json.ContactJson
import com.dawn.android.place.infra.api.json.PlaceJson
import kotlinx.serialization.Serializable

@Serializable
data class UserRegistrationJson(
    val id: Long = 0,
    val userName: String,
    val email: String,
    val password: String,
    val image: String,
    val displayName: String,
    val dateOfBirth: String,
    val sex: Int,
    val contacts: ContactJson,
    val address: PlaceJson,
)
