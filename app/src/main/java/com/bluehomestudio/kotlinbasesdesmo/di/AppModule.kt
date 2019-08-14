package com.bluehomestudio.kotlinbasesdesmo.di

import androidx.preference.PreferenceManager
import com.bluehomestudio.kotlinbasesdesmo.base.BaseApp
import org.koin.dsl.module

val AppModule = module {

    single { BaseApp.appContext }

    single { PreferenceManager.getDefaultSharedPreferences(get ()) }

}