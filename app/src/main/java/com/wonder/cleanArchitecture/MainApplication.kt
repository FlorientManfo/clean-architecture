package com.wonder.cleanArchitecture

import android.app.Application
import com.wonder.data.di.dataModule
import com.wonder.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MainApplication)
            modules(domainModule)
            modules(dataModule)
        }

    }
}