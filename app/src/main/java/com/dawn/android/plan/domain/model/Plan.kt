package com.dawn.android.plan.domain.model

import com.dawn.android.user.domain.model.Creator
import java.time.Instant

data class Plan(
    val id: PlanId,
    val title: String,
    val description: String,
    val imageUrl: String,
    val creator: Creator,
    val createdAt: Instant,
)
