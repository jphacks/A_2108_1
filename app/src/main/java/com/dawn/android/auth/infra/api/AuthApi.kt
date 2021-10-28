package com.dawn.android.auth.infra.api

import com.dawn.android.auth.infra.api.json.LoginRequestJson
import com.dawn.android.auth.infra.api.json.TokenJson
import com.dawn.android.auth.infra.api.json.UserRegistrationJson
import io.ktor.client.HttpClient
import io.ktor.client.request.post

class AuthApi(
    private val httpClient: HttpClient,
) {
    suspend fun login(loginRequest: LoginRequestJson): TokenJson {
        return httpClient.post("/login") {
            body = loginRequest
        }
    }

    suspend fun register(userRegistration: UserRegistrationJson): TokenJson {
        return httpClient.post("/register") {
            body = userRegistration
        }
    }
}
