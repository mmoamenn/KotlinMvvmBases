package com.bluehomestudio.kotlinbasesdesmo.domain.usecase

import com.bluehomestudio.kotlinbasesdesmo.core.di.AppModule
import com.bluehomestudio.kotlinbasesdesmo.domain.respository.ForceUpdateRepository

import org.junit.Test

import org.junit.Before
import org.koin.core.context.startKoin
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bluehomestudio.kotlinbasesdesmo.core.Model.None
import com.bluehomestudio.kotlinbasesdesmo.data.response.ForceUpdateResponse
import com.nhaarman.mockito_kotlin.given
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.rules.TestRule
import org.junit.Rule
import org.koin.dsl.koinApplication
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.Mock
import org.mockito.MockitoAnnotations


open class ForceUpdateUseCaseTest : AutoCloseKoinTest() {

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    private val forceUpdateUseCase: ForceUpdateUseCase by inject()

    @Before
    fun before() {

        MockitoAnnotations.initMocks(this)

        startKoin {
            modules(AppModule)
        }



    }

    @Test
    fun checkForceUpdate() = runBlocking {


        val resultResponse = ForceUpdateResponse(true, "")

        declareMock<ForceUpdateRepository> {
            given(runBlocking { this@declareMock.getCheckForceUpdate() }).willReturn(resultResponse)
        }

        forceUpdateUseCase(None())

        val result = forceUpdateUseCase.forceUpdateLiveData
        result.observeForever { }
        delay(100)

        assert(result.value!!.data!!.IsForceUpdate)
    }

}