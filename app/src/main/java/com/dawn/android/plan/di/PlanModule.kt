package com.dawn.android.plan.di

import com.dawn.android.plan.detail.ui.PlanDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val uiModule = module {
    viewModel { params ->
        PlanDetailViewModel(params[0])
    }
}

val planModule = listOf(
    uiModule,
)
