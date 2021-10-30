package com.dawn.android.place.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class AddressJson(
    val id: Long,
    val plusCode: String,
)
