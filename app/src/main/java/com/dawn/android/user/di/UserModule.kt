package com.dawn.android.user.di

import com.dawn.android.user.domain.repository.UserRepository
import com.dawn.android.user.infra.api.UserApi
import com.dawn.android.user.infra.impl.domain.repository.UserRepositoryImpl
import com.dawn.android.user.ui.mypage.MyPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val infraModule = module {
    single { UserApi(get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
}

private val uiModule = module {
    viewModel {
        MyPageViewModel(get(), get())
    }
}

val userModule = listOf(
    infraModule,
    uiModule,
)
