package com.bluehomestudio.kotlinbasesdesmo.core.di

import androidx.preference.PreferenceManager
import com.bluehomestudio.kotlinbasesdesmo.core.base.BaseApp
import com.bluehomestudio.kotlinbasesdesmo.data.network.NetworkManager
import com.bluehomestudio.kotlinbasesdesmo.data.repository.ForceUpdateRepositoryImpl
import com.bluehomestudio.kotlinbasesdesmo.domain.respository.ForceUpdateRepository
import com.bluehomestudio.kotlinbasesdesmo.domain.usecase.ForceUpdateUseCase
import com.bluehomestudio.kotlinbasesdesmo.ui.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    single { BaseApp.appContext }

    single { PreferenceManager.getDefaultSharedPreferences(get ()) }

    single { NetworkManager() }

    single<ForceUpdateRepository> { ForceUpdateRepositoryImpl() }

    single { ForceUpdateUseCase() }

    viewModel { MainViewModel(get ()) }

}


