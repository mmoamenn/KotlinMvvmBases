package com.bluehomestudio.kotlinbasesdesmo.data.network

import com.bluehomestudio.kotlinbasesdesmo.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkManager {


    fun secureRequest(): Retrofit {
        val client = OkHttpClient.Builder().apply {
            addInterceptor(requestInterceptor)
            addInterceptor(NetworkInterceptor())
            setOkHttpClientTimeouts(this)
        }
        return getRetrofitInstance(client)
    }

    fun insecureRequest(): Retrofit {
        val client = OkHttpClient.Builder().apply {
            addInterceptor(requestInterceptor)
            setOkHttpClientTimeouts(this)
        }
        return getRetrofitInstance(client)
    }

    fun mockedRequest(any : Any): Retrofit {
        val client = OkHttpClient.Builder().apply {
            addInterceptor(MockInterceptor(any))
            setOkHttpClientTimeouts(this)
        }
        return getRetrofitInstance(client)
    }

    private val requestInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun setOkHttpClientTimeouts(client: OkHttpClient.Builder): OkHttpClient.Builder {
        client.connectTimeout(30, TimeUnit.SECONDS)
        client.readTimeout(30, TimeUnit.SECONDS)
        client.writeTimeout(30, TimeUnit.SECONDS)
        return client
    }

    private fun getRetrofitInstance(okHttpClient: OkHttpClient.Builder): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()

    }

}