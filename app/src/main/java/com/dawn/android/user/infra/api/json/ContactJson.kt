package com.dawn.android.user.infra.api.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContactJson(
    val id: Long,
    @SerialName("hp")
    val hpLink: String?,
    @SerialName("instagram")
    val instagramLink: String?,
    @SerialName("twitter")
    val twitterLink: String?,
    @SerialName("facebook")
    val facebookLink: String?,
    @SerialName("tiktok")
    val tiktokLink: String?,
    val biography: String? = "",
)
