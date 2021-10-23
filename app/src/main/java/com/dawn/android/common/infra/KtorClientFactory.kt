package com.dawn.android.common.infra

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.defaultRequest
import io.ktor.http.URLProtocol

class KtorClientFactory {
    fun provide(): HttpClient {
        return HttpClient(CIO) {
            defaultRequest {
                url.host = "dawn.shinbunbun.info"
                url.protocol = URLProtocol.HTTPS
            }
        }
    }
}
