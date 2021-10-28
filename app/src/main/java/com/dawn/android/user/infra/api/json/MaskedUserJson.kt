package com.dawn.android.user.infra.api.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MaskedUserJson(
    val id: Long,
    val userName: String,
    val email: String,
    @SerialName("image")
    val imageUrl: String,
    val displayName: String,
    val dateOfBirth: String,
    val sex: Int,
    val contacts: ContactJson,
    val creator: CreatorJson,
)
