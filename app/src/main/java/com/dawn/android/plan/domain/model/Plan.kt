package com.dawn.android.plan.domain.model

import com.dawn.android.user.domain.model.Creator

data class Plan(
    val id: PlanId,
    val title: String,
    val description: String,
    val creator: Creator,
)
