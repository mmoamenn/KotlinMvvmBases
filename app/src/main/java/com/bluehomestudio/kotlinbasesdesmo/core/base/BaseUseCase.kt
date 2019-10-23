package com.bluehomestudio.kotlinbasesdesmo.core.base

import kotlinx.coroutines.*

abstract class BaseUseCase<Type : Any , Cache ,in Params >    {

    private  var mainJob: Job? = null

    abstract suspend fun run(params: Params) : Type

    abstract fun loading()

    abstract fun onSuccess(result : Type)

    abstract fun failed(exception : Exception)

    open suspend fun cache() : Cache {
        return NoCache() as Cache
    }

    open fun onCache(result : Cache){

    }

    operator fun invoke(params : Params ){
        mainJob = GlobalScope.launch(Dispatchers.Main) {
                try {
                    loading()

                    val cacheJob = withContext(Dispatchers.IO){
                        cache()
                    }

                    cacheJob?.run {
                        onCache(cacheJob)
                    }

                    val remoteJob = withContext(Dispatchers.IO) {
                        run(params)
                    }
                    onSuccess(remoteJob)
                }catch (e: Exception){
                    failed(e)
                }
        }
    }

    fun cancel(){
        mainJob?.cancel()
    }

    class None

    class NoCache

}