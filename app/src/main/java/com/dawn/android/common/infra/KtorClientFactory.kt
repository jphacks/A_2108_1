package com.dawn.android.common.infra

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.URLProtocol

class KtorClientFactory {
    fun provide(): HttpClient {
        return HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
            defaultRequest {
                url.host = "dawn.shinbunbun.info"
                url.protocol = URLProtocol.HTTPS
            }
        }
    }
}
