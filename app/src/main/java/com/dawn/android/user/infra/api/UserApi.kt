package com.dawn.android.user.infra.api

import com.dawn.android.user.infra.api.json.UserJson
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header

class UserApi(
    private val httpClient: HttpClient,
) {
    suspend fun getMe(token: String): UserJson {
        return httpClient.get("/user") {
            header("Authorization", "Bearer $token")
        }
    }
}
