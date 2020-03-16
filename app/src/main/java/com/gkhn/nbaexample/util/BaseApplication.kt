package com.gkhn.nbaexample.util

import android.app.Application
import com.gkhn.nbaexample.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger()
            androidContext(this@BaseApplication)
            modules(appModule)
        }
    }
}