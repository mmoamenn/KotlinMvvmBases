package com.bluehomestudio.kotlinbasesdesmo.di

import androidx.preference.PreferenceManager
import com.bluehomestudio.kotlinbasesdesmo.base.BaseApp
import com.bluehomestudio.kotlinbasesdesmo.base.BaseRepository
import com.bluehomestudio.kotlinbasesdesmo.utils.PreferenceUtils
import org.koin.dsl.module
import kotlin.math.sin

val AppModule = module {

    single { BaseApp.appContext }

    single { PreferenceManager.getDefaultSharedPreferences(get ()) }

}