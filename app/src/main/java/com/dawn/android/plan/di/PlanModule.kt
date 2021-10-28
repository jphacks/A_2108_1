package com.dawn.android.plan.di

import com.dawn.android.plan.detail.ui.PlanDetailViewModel
import com.dawn.android.plan.domain.repository.PlanRepository
import com.dawn.android.plan.infra.api.PlanApi
import com.dawn.android.plan.infra.impl.domain.repository.PlanRepositoryImpl
import com.dawn.android.plan.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val infraModule = module {
    single { PlanApi(get()) }
    single<PlanRepository> { PlanRepositoryImpl(get()) }
}

private val uiModule = module {
    viewModel { params ->
        PlanDetailViewModel(params[0], get())
    }
    viewModel {
        HomeViewModel(get())
    }
}

val planModule = listOf(
    infraModule,
    uiModule,
)
