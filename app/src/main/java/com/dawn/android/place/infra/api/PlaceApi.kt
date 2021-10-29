package com.dawn.android.place.infra.api

import com.dawn.android.place.infra.api.json.PlaceJson
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class PlaceApi(
    private val httpClient: HttpClient,
) {
    suspend fun getAreas(): List<PlaceJson> {
        return httpClient.get("/place")
    }

    suspend fun getPrefectures(areaId: Int): List<PlaceJson> {
        return httpClient.get("/place") {
            parameter("area", areaId)
        }
    }

    suspend fun getCities(prefectureId: Int): List<PlaceJson> {
        return httpClient.get("/place") {
            parameter("pref", prefectureId)
        }
    }
}
