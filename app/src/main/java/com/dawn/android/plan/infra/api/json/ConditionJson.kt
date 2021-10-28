package com.dawn.android.plan.infra.api.json

import kotlinx.serialization.Serializable

@Serializable
data class ConditionJson(
    val id: Long,
    val season: List<SeasonJson>,
    val timeSpan: List<TimeSpanJson>,
    val category: List<CategoryJson>,
)
