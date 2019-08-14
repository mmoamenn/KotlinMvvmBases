package com.bluehomestudio.kotlinbasesdesmo.base

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.bluehomestudio.kotlinbasesdesmo.di.AppModule
import com.bluehomestudio.kotlinbasesdesmo.utils.LocaleManager
import org.koin.core.context.startKoin

open class BaseApp : Application(){

    companion object {
        lateinit var localeManager: LocaleManager
        lateinit var appContext : Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin {
            modules(AppModule)
        }
    }

    override fun attachBaseContext(base: Context) {
        localeManager = LocaleManager(base)
        super.attachBaseContext(localeManager.setLocale(base))
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localeManager.setLocale(this)
    }




}