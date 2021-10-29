package com.dawn.android.plan.domain.model

import com.dawn.android.place.domain.model.Place

data class Condition(
    val id: ConditionId,
    val seasons: List<Season>,
    val timeSpans: List<TimeSpan>,
    val categories: List<Category>,
    val places: List<Place>,
    val estimatedCost: Int,
)
