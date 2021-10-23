package com.dawn.android

import android.app.Application
import com.dawn.android.common.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DawnApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DawnApplication)
            modules(
                commonModule,
            )
        }
    }
}
