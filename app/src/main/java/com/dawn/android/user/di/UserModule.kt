package com.dawn.android.user.di

import com.dawn.android.auth.domain.service.SignUpService
import com.dawn.android.auth.domain.service.TokenProvider
import com.dawn.android.auth.infra.impl.domain.service.SignUpServiceImpl
import com.dawn.android.auth.infra.impl.domain.service.TokenProviderImpl
import com.dawn.android.auth.infra.preferences.TokenPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val infraModule = module {
    single { TokenPreferences(androidContext()) }
    single<TokenProvider> { TokenProviderImpl(get()) }
    single<SignUpService> { SignUpServiceImpl(get()) }
}

val userModule = listOf(
    infraModule,
)
