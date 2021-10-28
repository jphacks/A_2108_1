package com.dawn.android.plan.domain.model

data class Condition(
    val id: ConditionId,
    val seasons: List<Season>,
    val timeSpans: List<TimeSpan>,
    val categories: List<Category>,
)
