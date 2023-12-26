package com.example.googlemapstest.app

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.googlemapstest.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(uiModule, dataModule, domainModule)
        }
    }
}