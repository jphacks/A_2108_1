package com.dawn.android.user.domain.model

data class Contact(
    val hpLink: String?,
    val instagramLink: String?,
    val twitterLink: String?,
    val facebookLink: String?,
    val tiktokLink: String?,
    val biography: String,
) {
    companion object {
        fun empty(): Contact {
            return Contact(
                hpLink = null,
                instagramLink = null,
                twitterLink = null,
                facebookLink = null,
                tiktokLink = null,
                biography = "",
            )
        }
    }
}
