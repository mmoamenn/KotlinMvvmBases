package com.bluehomestudio.kotlinbasesdesmo.data.network

import com.bluehomestudio.kotlinbasesdesmo.BuildConfig
import com.google.gson.Gson
import okhttp3.*

class MockInterceptor ( var any : Any ) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (BuildConfig.DEBUG) {
            val responseString = Gson().toJson(any)
            return chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .message(responseString)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString.toByteArray()))
                .addHeader("content-type", "application/json")
                .build()
        } else {
            throw IllegalAccessError("Hey man/lady you can not use this interceptor in release :| ")
        }
    }

}