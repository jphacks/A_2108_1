package com.dawn.android

import android.app.Application
import com.dawn.android.auth.di.authModule
import com.dawn.android.common.commonModule
import com.dawn.android.place.di.placeModule
import com.dawn.android.plan.di.planModule
import com.dawn.android.user.di.userModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DawnApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DawnApplication)
            val modules = listOf(
                commonModule,
                planModule,
                authModule,
                userModule,
                placeModule,
            ).flatten()
            modules(modules)
        }
    }
}
