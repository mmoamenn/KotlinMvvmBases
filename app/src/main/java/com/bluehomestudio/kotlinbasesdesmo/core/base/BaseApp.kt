package com.bluehomestudio.kotlinbasesdesmo.core.base

import android.content.Context
import android.content.res.Configuration
import androidx.multidex.MultiDexApplication
import com.bluehomestudio.kotlinbasesdesmo.core.di.AppModule
import com.bluehomestudio.kotlinbasesdesmo.core.utils.LocaleManager
import org.koin.core.context.startKoin

open class BaseApp : MultiDexApplication(){

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