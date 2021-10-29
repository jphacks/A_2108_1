package com.dawn.android.user.di

import com.dawn.android.user.ui.mypage.MyPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val uiModule = module {
    viewModel {
        MyPageViewModel(get())
    }
}

val userModule = listOf(
    uiModule,
)
