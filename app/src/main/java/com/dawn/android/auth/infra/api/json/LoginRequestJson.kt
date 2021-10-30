package com.dawn.android.auth.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestJson(
    val email: String,
    val password: String,
)
