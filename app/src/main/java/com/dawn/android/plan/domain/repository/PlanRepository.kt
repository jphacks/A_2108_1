package com.dawn.android.plan.domain.repository

import com.dawn.android.plan.domain.model.Plan
import com.dawn.android.plan.domain.model.PlanDetail
import com.dawn.android.plan.domain.model.PlanId

interface PlanRepository {
    suspend fun getAll(): List<Plan>
    suspend fun get(id: PlanId): PlanDetail
}