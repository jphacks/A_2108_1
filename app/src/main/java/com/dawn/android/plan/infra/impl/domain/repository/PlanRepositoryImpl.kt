package com.dawn.android.plan.infra.impl.domain.repository

import com.dawn.android.plan.domain.model.Plan
import com.dawn.android.plan.domain.model.PlanDetail
import com.dawn.android.plan.domain.model.PlanId
import com.dawn.android.plan.domain.repository.PlanRepository
import com.dawn.android.plan.infra.api.PlanApi
import com.dawn.android.plan.infra.converter.PlanConverter

class PlanRepositoryImpl(
    private val planApi: PlanApi,
) : PlanRepository {
    override suspend fun getAll(): List<Plan> {
        return planApi
            .getAllPlan()
            .map {
                PlanConverter.convertToDomainModel(it)
            }
    }

    override suspend fun get(id: PlanId): PlanDetail {
        return planApi
            .getPlanDetail(id.value)
            .let {
                PlanConverter.convertToDomainModel(it)
            }
    }
}
