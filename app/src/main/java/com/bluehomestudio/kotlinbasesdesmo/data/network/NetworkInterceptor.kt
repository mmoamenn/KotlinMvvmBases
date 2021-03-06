package com.bluehomestudio.kotlinbasesdesmo.data.network

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder().apply {
            header("Content-Type", "application/json")
        }
        val request = requestBuilder.method(original.method(), original.body()).build()
        return chain.proceed(request)
    }

}