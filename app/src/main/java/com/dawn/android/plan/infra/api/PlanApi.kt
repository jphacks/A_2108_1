package com.dawn.android.plan.infra.api

import com.dawn.android.plan.infra.api.json.PlanDetailJson
import com.dawn.android.plan.infra.api.json.PlanJson
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class PlanApi(
    private val httpClient: HttpClient,
) {
    suspend fun getAllPlan(): List<PlanJson> {
        return try {
            httpClient.get("/plan")
        } catch (e: Exception) {
            listOf()
        }
    }

    suspend fun getPlanDetail(id: Long): PlanDetailJson {
        return httpClient.get("/plan/$id")
    }
}
