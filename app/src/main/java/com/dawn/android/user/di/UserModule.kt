package com.dawn.android.user.di

import com.dawn.android.user.domain.service.TokenProvider
import com.dawn.android.user.infra.impl.domain.service.TokenProviderImpl
import com.dawn.android.user.infra.preferences.TokenPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val infraModule = module {
    single { TokenPreferences(androidContext()) }
    single<TokenProvider> { TokenProviderImpl(get()) }
}

val userModule = listOf(
    infraModule,
)
