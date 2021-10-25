package com.dawn.android.plan.domain.repository

import com.dawn.android.plan.domain.model.Plan
import com.dawn.android.plan.domain.model.PlanDetail
import com.dawn.android.plan.domain.model.PlanId

interface PlanRepository {
    fun getAll(): List<Plan>
    fun get(id: PlanId): PlanDetail
}