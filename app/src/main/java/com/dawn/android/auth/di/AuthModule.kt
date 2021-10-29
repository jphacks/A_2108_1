package com.dawn.android.auth.di

import com.dawn.android.auth.domain.service.AccountService
import com.dawn.android.auth.infra.api.AuthApi
import com.dawn.android.auth.infra.impl.domain.service.AccountServiceImpl
import com.dawn.android.auth.infra.preferences.TokenPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val infraModule = module {
    single { TokenPreferences(androidContext()) }
    single { AuthApi(get()) }
    single<AccountService> { AccountServiceImpl(get(), get()) }
}

val authModule = listOf(
    infraModule,
)