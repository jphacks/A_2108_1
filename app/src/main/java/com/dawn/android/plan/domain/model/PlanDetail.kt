package com.dawn.android.plan.domain.model

import com.dawn.android.user.domain.model.Creator

data class PlanDetail(
    val id: PlanId,
    val title: String,
    val description: String,
    val imageUrl: String,
    val creator: Creator,
    val days: List<Day>,
    val condition: Condition,
)
