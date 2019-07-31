package com.bluehomestudio.kotlinbasesdesmo.base

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.bluehomestudio.kotlinbasesdesmo.R
import com.bluehomestudio.kotlinbasesdesmo.utils.LocaleManager

open class BaseApp : Application(){

    companion object {
        lateinit var localeManager: LocaleManager
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