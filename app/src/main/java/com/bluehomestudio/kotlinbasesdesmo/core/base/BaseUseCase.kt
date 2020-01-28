package com.bluehomestudio.kotlinbasesdesmo.core.base

import kotlinx.coroutines.*

abstract class BaseUseCase<Type : Any, in Params> {

    private var mainJob: Job? = null

    abstract suspend fun run(params: Params): Type

    abstract fun loading()

    abstract fun onSuccess(result: Type)

    abstract fun failed(exception: Exception)

    operator fun invoke(params: Params) {
        mainJob = GlobalScope.launch(Dispatchers.IO) {
            try {
                loading()
                onSuccess(run(params))
            } catch (e: Exception) {
                failed(e)
            }
        }
    }

    fun cancel() {
        mainJob?.cancel()
    }

}