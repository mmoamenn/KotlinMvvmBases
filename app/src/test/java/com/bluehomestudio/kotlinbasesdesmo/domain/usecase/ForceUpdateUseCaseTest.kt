package com.bluehomestudio.kotlinbasesdesmo.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.bluehomestudio.kotlinbasesdesmo.core.di.AppModule
import com.bluehomestudio.kotlinbasesdesmo.data.network.Data
import com.bluehomestudio.kotlinbasesdesmo.domain.model.ForceUpdate
import com.bluehomestudio.kotlinbasesdesmo.domain.respository.ForceUpdateRepository
import com.nhaarman.mockito_kotlin.*

import org.junit.Test

import org.junit.Before
import org.koin.core.context.startKoin
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bluehomestudio.kotlinbasesdesmo.data.response.ForceUpdateResponse
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.rules.TestRule
import org.junit.Rule
import org.koin.test.AutoCloseKoinTest
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class ForceUpdateUseCaseTest : AutoCloseKoinTest() {

    @Rule @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var forceUpdateRepository : ForceUpdateRepository

    private lateinit var forceUpdateUseCase : ForceUpdateUseCase

    @Before
    fun before() {
        startKoin {
            modules(AppModule)
        }
    }

    @Test
    fun checkForceUpdate() {

    }

}