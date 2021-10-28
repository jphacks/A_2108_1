package com.dawn.android.common

import com.dawn.android.common.infra.KtorClientFactory
import org.koin.dsl.module

val infraModule = module {
    factory {
        KtorClientFactory().provide()
    }
}

val commonModule = listOf(
    infraModule,
)
