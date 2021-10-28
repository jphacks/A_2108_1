package com.dawn.android.user.infra.api

import com.dawn.android.user.infra.api.json.TokenJson
import com.dawn.android.user.infra.api.json.UserRegistrationJson
import io.ktor.client.HttpClient
import io.ktor.client.request.post

class UserApi(
    private val httpClient: HttpClient,
) {
    suspend fun register(userRegistration: UserRegistrationJson): TokenJson {
        return httpClient.post("/register") {
            body = userRegistration
        }
    }
}