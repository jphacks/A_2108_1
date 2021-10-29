package com.dawn.android.place.di

import com.dawn.android.place.domain.repository.PlaceRepository
import com.dawn.android.place.infra.api.PlaceApi
import com.dawn.android.place.infra.impl.domain.repository.PlaceRepositoryImpl
import org.koin.dsl.module

private val infraModule = module {
    single { PlaceApi(get()) }
    single<PlaceRepository> { PlaceRepositoryImpl(get()) }
}

val placeModule = listOf(
    infraModule,
)
